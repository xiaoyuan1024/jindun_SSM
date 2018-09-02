package yuan.zhang.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yuan.zhang.entity.Record;

public interface RecordService {
	// 获取当前页面中所有通行记录
	public List<Record> getRecordCurrentPage(int currentPage, int pageSize, String startTime, String username);

	// 获取数据总条数
	public int getTotalCount(String startTime, String username);

	// 按照用户名和车牌号查询
	public List<Record> queryRecordByPlateUsername(String plate, String username);

	// 按结算时间查询
	public List<Record> queryRecordByStartTime(Integer LTID, String plate, String startTimeScope,
			String endTimeScope);

	// 按照消费时间查询
	public List<Record> queryRecordByArrivalTime(Integer LTID, String plate, String startTimeScope,
			String endTimeScope);
	// 月份查询：按消费时间(startTime)查询
	public List<Record> queryRecordByMonStartTime(String username, String plate, String Mouth);

	// 月份查询：按结算时间(arrivalTime)查询
	public List<Record> queryRecordByMonArrivalTime(String username, String plate, String Mouth);

	// 用户信息界面：根据用户名查询通行记录数据显示
	public List<Record> selectRecord(String username);

	// 用户信息界面：点击查询，按照车牌号码查询
	public List<Record> selectByPlate(String plate);
}
