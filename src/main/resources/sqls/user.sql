/* findByAccAndPwd*/
SELECT * FROM man_users WHERE user_account=@acc and user_pwd=@pwd;

/*findMenu*/
SELECT bm.* FROM base_menu bm
LEFT JOIN roles_menu_rel rmr ON rmr.menu_id = bm.menu_id
LEFT JOIN user_roles_rel urr ON rmr.role_id = urr.role_id
LEFT JOIN man_users mu ON mu.user_id= urr.user_id
WHERE mu.user_id = @userId

/*queryUser*/
SELECT mu.*,mr.id AS userRole FROM man_users mu
LEFT JOIN user_roles_rel ur ON ur.user_id = mu.user_id
LEFT JOIN man_roles mr ON mr.id = ur.role_id
WHERE mu.user_id=@userId

/*getUserLists*/
SELECT mu.*,mr.`name` AS roleName FROM man_users mu
LEFT JOIN user_roles_rel ur ON ur.user_id = mu.user_id
LEFT JOIN man_roles mr ON mr.id = ur.role_id
WHERE mr.id <> 1
$condition

/*getSubMenu*/
SELECT bm.* FROM base_menu bm WHERE bm.menu_pCode = @pMenuCode