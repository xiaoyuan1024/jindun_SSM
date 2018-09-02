package yuan.zhang.service.imp;

import java.util.List;

import yuan.zhang.dao.RecordDao;
import yuan.zhang.entity.Record;
import yuan.zhang.service.RecordService;

public class RecordServiceImp implements RecordService {

	// setter方式注入
	private RecordDao recordDao;// 成员变量名对应Spring配置文件bean中的name

	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;// 参数名对应Spring配置文件bean中的ref
	}

	// 获取当前页面中所有通行记录
	@Override
	public List<Record> getRecordCurrentPage(int currentPage, int pageSize, String startTime, String username) {
		return recordDao.getRecordCurrentPage(currentPage, pageSize, startTime, username);
	}

	// 获取数据总条数
	@Override
	public int getTotalCount(String startTime, String username) {
		return recordDao.getTotalCount(startTime, username);
	}

	// 按照用户名和车牌号查询
	@Override
	public List<Record> queryRecordByPlateUsername(String plate, String username) {
		return recordDao.queryRecordByPlateUsername(plate, username);
	}

	// 按结算时间查询
	@Override
	public List<Record> queryRecordByStartTime(Integer LTID, String plate, String startTimeScope,
			String endTimeScope) {
		return recordDao.queryRecordByStartTime(LTID, plate, startTimeScope, endTimeScope);
	}

	// 按照消费时间查询
	@Override
	public List<Record> queryRecordByArrivalTime(Integer LTID, String plate, String startTimeScope,
			String endTimeScope) {
		return recordDao.queryRecordByArrivalTime(LTID, plate, startTimeScope, endTimeScope);
	}

	// 月份查询：按消费时间(startTime)查询
	@Override
	public List<Record> queryRecordByMonStartTime(String username, String plate, String Mouth) {
		return recordDao.queryRecordByMonStartTime(username, plate, Mouth);
	}

	// 月份查询：按结算时间(arrivalTime)查询
	@Override
	public List<Record> queryRecordByMonArrivalTime(String username, String plate, String Mouth) {
		return recordDao.queryRecordByMonArrivalTime(username, plate, Mouth);
	}

	// 用户信息界面：根据用户名查询通行记录数据显示
	@Override
	public List<Record> selectRecord(String username) {
		return recordDao.selectRecord(username);
	}

	// 用户信息界面：点击查询，按照车牌号码查询
	@Override
	public List<Record> selectByPlate(String plate) {
		return recordDao.selectByPlate(plate);
	}

}
