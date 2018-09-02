package yuan.zhang.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import yuan.zhang.entity.Page;
import yuan.zhang.entity.Record;
import yuan.zhang.service.RecordService;

@Controller
@RequestMapping("record")
public class RecordController {

	// 指定@Autowired标识的属性，按“属性名”自动装配
	@Autowired
	@Qualifier("recordService")
	private RecordService recordService;

	// 获取当前页面中所有通行记录
/*	@RequestMapping("getRecordCurrentPage")
	public String getRecordCurrentPage(@RequestParam("currentPage") Integer currentPage,
			@RequestParam("pageSize") Integer pageSize, @RequestParam("startTime") String startTime,
			@RequestParam("username") String username, Map<String, Object> map) {
		List<Record> records = recordService.getRecordCurrentPage(currentPage, pageSize, startTime, username);
		map.put("records", records);
		return "";
	}*/
	// 获取当前页面中所有通行记录
	@RequestMapping("getRecordCurrentPage")
	public void getRecordCurrentPage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		/**设置编码格式统一为utf-8*/
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//		/*获取record2.jsp中的消费时间*/
		String startTime = request.getParameter("starttime");
//		
		String currentPage = request.getParameter("currentPage");
		String username = request.getParameter("username");
		//String pageSize = request.getParameter("pageSize");
		if (currentPage==null) {
			currentPage = "1";
		}
		int currentPageNo = Integer.parseInt(currentPage);
		/*调用业务逻辑*/
		//RecordService service = new RecordService();
		int totalCount = recordService.getTotalCount(startTime,username);
		Page page = new Page();
		// 如果currentPage的值为null,说明是第一次进入此Servlet,故设为第 1 页
		/*if (pageSize != null) {
			page.setPageSize(Integer.parseInt(pageSize));
		}else {
			page.setPageSize(5);
		}*/
		page.setPageSize(2);
		/*设置总记录数*/
		page.setTotalCount(totalCount);
		/*获取总页数*/
		int totalPage = page.getTotalPage();
		/*首尾页控制*/
		if (currentPageNo < 1) {
			currentPageNo = 1;
		}else if (currentPageNo > page.getTotalPage()) {
			currentPageNo = totalPage;
		}
		/*设置当前页的页码*/
		page.setCurrentPage(currentPageNo);
		List<Record> records = recordService.getRecordCurrentPage(page.getCurrentPage(),page.getPageSize(),startTime,username);
		page.setRecords(records);
		page.setUsername(username);
		System.out.println(records.toString());
		/*list对象放入request作用域中*/
		request.setAttribute("page",page);
		/*请求转发*/
		request.getRequestDispatcher("/views/record_details.jsp").forward(request, response);
		
	//	List<Record> records = recordService.getRecordCurrentPage(currentPage, pageSize, startTime, username);
	}

	// 获取数据总条数
	@RequestMapping("getTotalCount")
	public String getTotalCount(@RequestParam("startTime") String startTime, @RequestParam("username") String username,
			Map<String, Object> map) {
		int count = recordService.getTotalCount(startTime, username);
		map.put("count", count);
		return "";
	}

	// 按照用户名和车牌号查询
	@RequestMapping("queryRecordByPlateUsername")
	public String queryRecordByPlateUsername(@RequestParam("plate") String plate,
			@RequestParam("username") String username, Map<String, Object> map) {
		List<Record> records = recordService.queryRecordByPlateUsername(plate, username);
		map.put("records", records);
		return "";
	}

	// 按时间查询
	@RequestMapping("queryRecordByTime")
	public String queryRecordByStartTime(@RequestParam("LTID") Integer LTID,
			@RequestParam("selectWay") String selectWay, @RequestParam("plate") String plate,
			@RequestParam("startTimeScope") String startTimeScope, @RequestParam("endTimeScope") String endTimeScope,
			Map<String, Object> map) throws Exception {
		String plate2=new String(plate.getBytes("ISO-8859-1"),"utf-8");
	//	Page page = new Page();s
		List<Record> records = new ArrayList<Record>();
		System.out.println(plate2+"\t"+LTID);
		if (selectWay.equals("consumeTime")) {
			System.out.println(startTimeScope);
			records = recordService.queryRecordByStartTime(LTID, plate2, startTimeScope, endTimeScope);
		} else if (selectWay.equals("closeTime")) {
			System.out.println(2222);
			records = recordService.queryRecordByArrivalTime(LTID, plate, startTimeScope, endTimeScope);
		}
		//page.setRecords(records);
		System.out.println(records);
		map.put("records", records);
		return "forward:/views/record_details_1.jsp";
	}

	// 月份查询：按消费时间(startTime)查询
/*	@RequestMapping("queryRecordByMonStartTime")
	public String queryRecordByMonStartTime(@RequestParam("username") String username,
			@RequestParam("plate") String plate, @RequestParam("Mouth") String Mouth, Map<String, Object> map) {
		List<Record> records = recordService.queryRecordByMonStartTime(username, plate, Mouth);
		map.put("records", records);
		return "";
	}*/

	// 月份查询：
/*	@RequestMapping("queryRecordByMonTime")
	public String queryRecordByMonArrivalTime(@RequestParam("username") String username,
			@RequestParam("plate") String plate, @RequestParam("Mouth") String Mouth, Map<String, Object> map) {
		List<Record> records = recordService.queryRecordByMonArrivalTime(username, plate, Mouth);
		map.put("records", records);
		return "";
	}*/
	
	static String now;
	static String last;
	@RequestMapping("queryRecordByMonTime")
	public void queryRecordByMonArrivalTime(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**设置编码格式统一为utf-8*/
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取各种参数
		String username=request.getParameter("username");
		String selectWay = request.getParameter("selectway");
		System.out.println(selectWay);
		String plate = request.getParameter("plate");
		String NowMonth = request.getParameter("nowmonth");
		System.out.println(NowMonth);
		String LastMonth = request.getParameter("lastmonth");
		String month = "";
		//获取时间
		Calendar c = Calendar.getInstance();
		String year = String.valueOf(c.get(Calendar.YEAR));
		int nowmonth = c.get(Calendar.MONTH)+1;
		int lastmonth = c.get(Calendar.MONTH);
		System.out.println(nowmonth);
		System.out.println(lastmonth);
		//判断月份
		if (nowmonth < 10) {
			now="/0"+nowmonth;
			System.out.println();
		}else {
			now="/"+nowmonth;
		}
		
		if (lastmonth<10) {
			last = "/0"+lastmonth;
		}else {
			last = "/"+lastmonth;
		}
		
		
		if ("查询本月".equals(NowMonth)) {
		month = year+now;
		System.out.println(month);
		}else if("查询上月".equals(LastMonth)) {
			month = year+last;
			System.out.println(month);
		}
		//RecordService service = new RecordService();
		List<Record> records = new ArrayList<Record>() ;
		Page page = new Page();
		//调用业务逻辑层
		if ("consumeTime".equals(selectWay)) {
			records = recordService.queryRecordByMonStartTime(username, plate, month);
			System.out.println(records);
		}else if("closeTime".equals(selectWay)) {
			records = recordService.queryRecordByMonArrivalTime(username, plate, month);
		}
		page.setRecords(records);
		request.setAttribute("pages", page);
		request.getRequestDispatcher("/views/record_details_1.jsp").forward(request, response);
		
/*		List<Record> records = recordService.queryRecordByMonArrivalTime(username, plate, Mouth);
		map.put("records", records);
		return "";*/
	}

	// 用户信息界面：根据用户名查询通行记录数据显示
	@RequestMapping("selectRecord")
	public String selectRecord(@RequestParam("username") String username, Map<String, Object> map) {
		List<Record> records = recordService.selectRecord(username);
		map.put("records", records);
		return "forward:/views/record.jsp";
	}

	// 用户信息界面：点击查询，按照车牌号码查询
	@RequestMapping("selectByPlate")
	public String selectByPlate(@RequestParam("plate") String plate, Map<String, Object> map) {
		List<Record> records = recordService.selectByPlate(plate);
		map.put("records", records);
		return "forward:/views/record_check.jsp";
	}
}
