package day03;

public interface B001Dao {
	/**
	 * ��B001���һ����¼
	 * insert into B001(id,name) values (?,?)
	 * @param b
	 */
	public void save(B001 b);
	/**
	 * ��B001����ĳһ����¼
	 * update B001 set name=? where id=?
	 * @param b
	 */
	public void update(B001 b);
	/**
	 * ɾ��B001��ָ��id��¼
	 * delete from B001 where id=?
	 * @param id
	 */
	public void delete(int id);
}
