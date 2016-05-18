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
	
	/**
	 * 
	 * 添加管理员
	 * @param po
	 * @return
	 */
	public boolean addAdmin(sellerAdminPO po);
	/**
	 * 修改管理员
	 * @param po
	 * @return
	 */
	public boolean updateAdmin(sellerAdminPO po);
	/**
	 * 删除管理员
	 * @param aids
	 * @return
	 */
	public boolean deleteAdmin(String aids);
	
}
