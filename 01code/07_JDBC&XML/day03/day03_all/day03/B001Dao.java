package day03;

public interface B001Dao {
	/**
	 * 向B001添加一条记录
	 * insert into B001(id,name) values (?,?)
	 * @param b
	 */
	public void save(B001 b);
	/**
	 * 向B001更新某一条记录
	 * update B001 set name=? where id=?
	 * @param b
	 */
	public void update(B001 b);
	/**
	 * 删除B001中指定id记录
	 * delete from B001 where id=?
	 * @param id
	 */
	public void delete(int id);
}
