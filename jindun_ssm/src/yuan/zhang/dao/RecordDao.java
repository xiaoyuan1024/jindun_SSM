package yuan.zhang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yuan.zhang.entity.Record;

public interface RecordDao {
	//(多个参数映射到配置文件使用注解的方式)
	// 获取当前页面中所有通行记录
	public List<Record> getRecordCurrentPage(@Param("currentPage")int currentPage, @Param("pageSize")int pageSize, @Param("startTime")String startTime, @Param("username")String username);

	// 获取数据总条数
	public int getTotalCount(@Param("startTime")String startTime,@Param("username") String username);

	// 按照用户名和车牌号查询
	public List<Record> queryRecordByPlateUsername(@Param("plate")String plate,@Param("username") String username);

	// 按结算时间查询
	public List<Record> queryRecordByStartTime(@Param("LTID")Integer LTID, @Param("plate")String plate, @Param("startTimeScope")String startTimeScope,@Param("endTimeScope")String endTimeScope);

	// 按照消费时间查询
	public List<Record> queryRecordByArrivalTime(@Param("LTID")Integer LTID, @Param("plate2")String plate, @Param("startTimeScope")String startTimeScope,@Param("endTimeScope")String endTimeScope);

	// 月份查询：按消费时间(startTime)查询
	public List<Record> queryRecordByMonStartTime(@Param("username")String username, @Param("plate")String plate,@Param("Mouth") String Mouth);

	// 月份查询：按结算时间(arrivalTime)查询
	public List<Record> queryRecordByMonArrivalTime(@Param("username")String username, @Param("plate")String plate,@Param("Mouth") String Mouth);

	//用户信息界面：根据用户名查询通行记录数据显示
	public List<Record> selectRecord(String username);

	//用户信息界面：点击查询，按照车牌号码查询
	public List<Record> selectByPlate(String plate);
}
