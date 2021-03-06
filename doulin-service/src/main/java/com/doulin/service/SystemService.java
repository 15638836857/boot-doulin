/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.doulin.service;

import com.doulin.common.password.Digests;
import com.doulin.common.password.Encodes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 * @author jeeplus
 * @version 2016-12-05
 */
@Service
@Transactional(readOnly = true)
public class SystemService implements Serializable {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
//	@Autowired
//	private DataRuleService dataRuleService;
//	@Autowired
//	private UserMapper userMapper;
//	@Autowired
//	private RoleMapper roleMapper;
//	@Autowired
//	private MenuMapper menuMapper;
//	@Autowired
//	private SessionDAO sessionDao;
//	public SessionDAO getSessionDao() {
//		return sessionDao;
//	}

	//-- User Service --//
	
//	/**
//	 * 获取用户
//	 * @param id
//	 * @return
//	 */
//	public User getUser(String id) {
//		return UserUtils.get(id);
//	}
//
//	/**
//	 * 根据登录名获取用户
//	 * @param loginName
//	 * @return
//	 */
//	public User getUserByLoginName(String loginName) {
//		//return UserUtils.getByLoginName(loginName);
//		return userMapper.getByLoginName(new User(null, loginName));
//	}
//	/**
//	 * 根据登录名获取社区商户
//	 * @param loginName
//	 * @return
//	 */
//	public User getCommunityByPhone(String loginName) {
//		//return UserUtils.getByLoginName(loginName);
//		return userMapper.getCommunityByPhone(loginName);
//	}
//	/**
//	 * 根据ID获取社区商户
//	 * @param loginName
//	 * @return
//	 */
//	public User getCommunityById(String id) {
//		//return UserUtils.getByLoginName(loginName);
//		return userMapper.getCommunityById(id);
//	}
//
//	public Page<User> findUser(Page<User> page, User user) {
//		dataRuleFilter(user);
//		// 设置分页参数
//		user.setPage(page);
//		// 执行分页查询
//		page.setList(userMapper.findList(user));
//		return page;
//	}
//	public Page<User> findAllUser(Page<User> page, User user) {
//		dataRuleFilter(user);
//		// 设置分页参数
//		user.setPage(page);
//		// 执行分页查询
//		page.setList(userMapper.getAllUserList(user));
//		return page;
//	}
//
//	/**
//	 * 无分页查询人员列表
//	 * @param user
//	 * @return
//	 */
//	public List<User> findUser(User user){
//		dataRuleFilter(user);
//		List<User> list = userMapper.findList(user);
//		return list;
//	}
//
//	/**
//	 * 通过部门ID获取用户列表，仅返回用户id和name（树查询用户时用）
//	 * @param user
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public List<User> findUserByOfficeId(String officeId) {
//		List<User> list = (List<User>)CacheUtils.get(UserUtils.USER_CACHE, UserUtils.USER_CACHE_LIST_BY_OFFICE_ID_ + officeId);
//		if (list == null){
//			User user = new User();
//			user.setOffice(new Office(officeId));
//			list = userMapper.findUserByOfficeId(user);
//			CacheUtils.put(UserUtils.USER_CACHE, UserUtils.USER_CACHE_LIST_BY_OFFICE_ID_ + officeId, list);
//		}
//		return list;
//	}
//
//	@Transactional(readOnly = false)
//	public void saveUser(User user) {
//		if (StringUtils.isBlank(user.getId())){
//			user.preInsert();
//			userMapper.insert(user);
//		}else{
//			// 清除原用户机构用户缓存
//			User oldUser = userMapper.get(user.getId());
//			if (oldUser.getOffice() != null && oldUser.getOffice().getId() != null){
//				CacheUtils.remove(UserUtils.USER_CACHE, UserUtils.USER_CACHE_LIST_BY_OFFICE_ID_ + oldUser.getOffice().getId());
//			}
//			// 更新用户数据
//			user.preUpdate();
//			userMapper.update(user);
//		}
//		if (StringUtils.isNotBlank(user.getId())){
//			// 更新用户与角色关联
//			userMapper.deleteUserRole(user);
//			if (user.getRoleList() != null && user.getRoleList().size() > 0){
//				userMapper.insertUserRole(user);
//			}else{
//				throw new ServiceException(user.getLoginName() + "没有设置角色！");
//			}
//			// 清除用户缓存
//			UserUtils.clearCache(user);
////			// 清除权限缓存
////			systemRealm.clearAllCachedAuthorizationInfo();
//		}
//	}
//
//	@Transactional(readOnly = false)
//	public void updateUserInfo(User user) {
//		user.preUpdate();
//		userMapper.updateUserInfo(user);
//		// 清除用户缓存
//		UserUtils.clearCache(user);
////		// 清除权限缓存
////		systemRealm.clearAllCachedAuthorizationInfo();
//	}
//
//	@Transactional(readOnly = false)
//	public void deleteUser(User user) {
//		userMapper.deleteUserRole(user);
//		userMapper.delete(user);
//		// 清除用户缓存
//		UserUtils.clearCache(user);
////		// 清除权限缓存
////		systemRealm.clearAllCachedAuthorizationInfo();
//	}
//
//	@Transactional(readOnly = false)
//	public void updatePasswordById(String id, String loginName, String newPassword) {
//		User user = new User(id);
//		user.setPassword(entryptPassword(newPassword));
//		userMapper.updatePasswordById(user);
//		// 清除用户缓存
//		user.setLoginName(loginName);
//		UserUtils.clearCache(user);
////		// 清除权限缓存
////		systemRealm.clearAllCachedAuthorizationInfo();
//	}
//
//	@Transactional(readOnly = false)
//	public void updateUserLoginInfo(User user) {
//		// 保存上次登录信息
//		user.setOldLoginIp(user.getLoginIp());
//		user.setOldLoginDate(user.getLoginDate());
//		// 更新本次登录信息
//		user.setLoginIp(UserUtils.getSession().getHost());
//		user.setLoginDate(new Date());
//		userMapper.updateLoginInfo(user);
//	}
//
	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 */
	public static String entryptPassword(String plainPassword) throws Exception {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
	}

	/**
	 * 验证密码
	 * @param plainPassword 明文密码
	 * @param password 密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validatePassword(String plainPassword, String password) throws Exception {
		byte[] salt = Encodes.decodeHex(password.substring(0,16));
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
	}

//	public static void main(String[] args) throws Exception {
//		String str=entryptPassword("123456");
//		System.out.println(str);
//		System.out.println(validatePassword("123456", str));
//	}
//
//	/**
//	 * 获得活动会话
//	 * @return
//	 */
//	public Collection<Session> getActiveSessions(){
//		return sessionDao.getActiveSessions(false);
//	}
//
//	//-- Role Service --//
//
//	public Role getRole(String id) {
//		return roleMapper.get(id);
//	}
//
//	public Role getRoleByName(String name) {
//		Role r = new Role();
//		r.setName(name);
//		return roleMapper.getByName(r);
//	}
//
//	public Role getRoleByEnname(String enname) {
//		Role r = new Role();
//		r.setEnname(enname);
//		return roleMapper.getByEnname(r);
//	}
//
//	public List<Role> findRole(Role role){
//		return roleMapper.findList(role);
//	}
//
//	public List<Role> findAllRole(){
//		return UserUtils.getRoleList();
//	}
//
//	@Transactional(readOnly = false)
//	public void saveRole(Role role) {
//		if (StringUtils.isBlank(role.getId())){
//			role.preInsert();
//			roleMapper.insert(role);
//		}else{
//			role.preUpdate();
//			roleMapper.update(role);
//		}
//		// 更新角色与菜单关联
//		roleMapper.deleteRoleMenu(role);
//		if (role.getMenuList().size() > 0){
//			roleMapper.insertRoleMenu(role);
//		}
//
//		// 更新角色与数据权限关联
//		roleMapper.deleteRoleDataRule(role);
//		if (role.getDataRuleList().size() > 0){
//			roleMapper.insertRoleDataRule(role);
//		}
//		// 清除用户角色缓存
//		UserUtils.removeCache(UserUtils.CACHE_ROLE_LIST);
////		// 清除权限缓存
////		systemRealm.clearAllCachedAuthorizationInfo();
//	}
//
//	@Transactional(readOnly = false)
//	public void deleteRole(Role role) {
//		roleMapper.deleteRoleMenu(role);
//		roleMapper.deleteRoleDataRule(role);
//		roleMapper.delete(role);
//		// 清除用户角色缓存
//		UserUtils.removeCache(UserUtils.CACHE_ROLE_LIST);
////		// 清除权限缓存
////		systemRealm.clearAllCachedAuthorizationInfo();
//	}
//
//	@Transactional(readOnly = false)
//	public Boolean outUserInRole(Role role, User user) {
//		List<Role> roles = user.getRoleList();
//		for (Role e : roles){
//			if (e.getId().equals(role.getId())){
//				roles.remove(e);
//				saveUser(user);
//				return true;
//			}
//		}
//		return false;
//	}
//
//	@Transactional(readOnly = false)
//	public User assignUserToRole(Role role, User user) {
//		if (user == null){
//			return null;
//		}
//		List<String> roleIds = user.getRoleIdList();
//		if (roleIds.contains(role.getId())) {
//			return null;
//		}
//		user.getRoleList().add(role);
//		saveUser(user);
//		return user;
//	}
//
//	//-- Menu Service --//
//
//	public Menu getMenu(String id) {
//		return menuMapper.get(id);
//	}
//
//	public List<Menu> findAllMenu(){
//		return UserUtils.getMenuList();
//	}
//
//	public List<Menu> getChildren(String parentId){
//		return menuMapper.getChildren(parentId);
//	}
//
//	@Transactional(readOnly = false)
//	public void saveMenu(Menu menu) {
//
//		// 获取父节点实体
//		menu.setParent(this.getMenu(menu.getParent().getId()));
//
//		// 获取修改前的parentIds，用于更新子节点的parentIds
//		String oldParentIds = menu.getParentIds();
//
//		// 设置新的父节点串
//		menu.setParentIds(menu.getParent().getParentIds()+menu.getParent().getId()+",");
//
//		// 保存或更新实体
//		if (StringUtils.isBlank(menu.getId())){
//			menu.preInsert();
//			menuMapper.insert(menu);
//		}else{
//			menu.preUpdate();
//			menuMapper.update(menu);
//		}
//
//		// 更新子节点 parentIds
//		Menu m = new Menu();
//		m.setParentIds("%,"+menu.getId()+",%");
//		List<Menu> list = menuMapper.findByParentIdsLike(m);
//		for (Menu e : list){
//			e.setParentIds(e.getParentIds().replace(oldParentIds, menu.getParentIds()));
//			menuMapper.updateParentIds(e);
//		}
//		// 清除用户菜单缓存
//		UserUtils.removeCache(UserUtils.CACHE_MENU_LIST);
////		// 清除权限缓存
////		systemRealm.clearAllCachedAuthorizationInfo();
//		// 清除日志相关缓存
//		CacheUtils.remove(LogUtils.CACHE_MENU_NAME_PATH_MAP);
//	}
//
//	@Transactional(readOnly = false)
//	public void updateMenuSort(Menu menu) {
//		menuMapper.updateSort(menu);
//		// 清除用户菜单缓存
//		UserUtils.removeCache(UserUtils.CACHE_MENU_LIST);
////		// 清除权限缓存
////		systemRealm.clearAllCachedAuthorizationInfo();
//		// 清除日志相关缓存
//		CacheUtils.remove(LogUtils.CACHE_MENU_NAME_PATH_MAP);
//	}
//
//	@Transactional(readOnly = false)
//	public void deleteMenu(Menu menu) {
//
//		// 解除菜单角色关联
//		List<Object> mrlist =  menuMapper.execSelectSql(
//				"SELECT distinct a.menu_id as id FROM sys_role_menu a left join sys_menu menu on a.menu_id = menu.id WHERE a.menu_id ='"
//						+ menu.getId() + "' OR menu.parent_ids LIKE  '%," + menu.getId() + ",%'");
//		for (Object mr : mrlist) {
//			menuMapper.deleteMenuRole(mr.toString());
//		}
//
//		// 删除菜单关联的数据权限数据，以及解除角色数据权限关联
//		List<Object> mdlist = menuMapper.execSelectSql(
//				"SELECT distinct a.id as id FROM sys_datarule a left join sys_menu menu on a.menu_id = menu.id WHERE a.menu_id ='"
//						+ menu.getId() + "' OR menu.parent_ids LIKE  '%," + menu.getId() + ",%'");
//		for (Object md : mdlist) {
//			DataRule dataRule = new DataRule(md.toString());
//			dataRuleService.delete(dataRule);
//		}
//
//		menuMapper.delete(menu);
//		// 清除用户菜单缓存
//		UserUtils.removeCache(UserUtils.CACHE_MENU_LIST);
//		// // 清除权限缓存
//		// systemRealm.clearAllCachedAuthorizationInfo();
//		// 清除日志相关缓存
//		CacheUtils.remove(LogUtils.CACHE_MENU_NAME_PATH_MAP);
//	}
//
//	/**
//	 * 获取产品信息
//	 */
//	public static boolean printKeyLoadMessage(){
//
//	/*	StringBuilder sb = new StringBuilder();
//		sb.append("\r\n ");
//		sb.append("██╗     ██╗██╗  ██╗██╗███╗   ██╗██╗  ██╗███████╗     ██╗██╗ \r\n ");
//		sb.append("██║     ██║╚██╗██╔╝██║████╗  ██║██║ ██╔╝██╔════╝     ██║██║ \r\n ");
//		sb.append("██║     ██║ ╚███╔╝ ██║██╔██╗ ██║█████╔╝ █████╗       ██║██║     欢迎使用 "+Global.getConfig("productName") + "\r\n ");
//		sb.append("██║     ██║ ██╔██╗ ██║██║╚██╗██║██╔═██╗ ██╔══╝  ██   ██║██║     http://www.lixinapp.com\r\n ");
//		sb.append("███████╗██║██╔╝ ██╗██║██║ ╚████║██║  ██╗███████╗╚█████╔╝██║   \r\n ");
//		sb.append("╚══════╝╚═╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝ ╚════╝ ╚═╝   \r\n ");
//		sb.append("...．．∵ ∴★．∴∵∴ ╭ ╯╭ ╯╭ ╯╭ ╯∴∵∴∵∴ \r\n ");
//		sb.append("．☆．∵∴∵．∴∵∴▍▍ ▍▍ ▍▍ ▍▍☆ ★∵∴ \r\n ");
//		sb.append("▍．∴∵∴∵．∴▅███████████☆ ★∵ \r\n ");
//		sb.append("◥█▅▅▅▅███▅█▅█▅█▅█▅█▅███◤          欢迎使用 "+Global.getConfig("productName")+Global.getConfig("version")+"\r\n ");
//		sb.append("． ◥███████████████████◤                    http://www.lixinapp.com\r\n ");
//		sb.append(".．.．◥████████████████■◤\r\n ");
//		System.out.println(sb.toString());*/
//		return true;
//	}
//	public void afterPropertiesSet() throws Exception {
//	}
//
//
}
