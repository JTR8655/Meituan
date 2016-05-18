package meituan.biz;

import java.util.List;

import meituan.po.ManagerPo;
import meituan.po.sellerAdminPO;


public interface IAdminBiz {
	/**
	 * 
	 * @param po
	 * @return
	 */
	public sellerAdminPO login(sellerAdminPO po);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<sellerAdminPO> findBypage(Integer pageNo,Integer pageSize);
	/**
	 * 
	 * @return
	 */
	public double getCount();
	
	/**nnnn
	 * 
	 * 娣诲姞绠＄悊鍛�
	 * @param po
	 * @return
	 */
	public boolean addAdmin(sellerAdminPO po);
	/**
	 * 淇敼绠＄悊鍛�j
	 * @param po
	 * @return
	 */
	public boolean updateAdmin(sellerAdminPO po);
	/**
	 * 鍒犻櫎绠＄悊鍛�
	 * @param aids
	 * @return
	 */
	public boolean deleteAdmin(String aids);
	
}
