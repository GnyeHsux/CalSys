/* findByAccAndPwd*/
SELECT * FROM man_users WHERE user_account=@acc and user_pwd=@pwd;

/*findMenu*/
SELECT bm.*,mu.user_name FROM base_menu bm
LEFT JOIN user_menu um ON bm.menu_code = um.menu_code
LEFT JOIN man_users mu ON mu.user_id = um.user_id
WHERE mu.user_id=@userId

/*queryUser*/
SELECT mu.*,mr.id AS userRole FROM man_users mu
LEFT JOIN user_roles_rel ur ON ur.user_id = mu.user_id
LEFT JOIN man_roles mr ON mr.id = ur.role_id
WHERE mu.user_id=@userId