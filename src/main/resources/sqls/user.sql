/* findByAccAndPwd*/
SELECT * FROM man_users WHERE user_account=@acc and user_pwd=@pwd;

/*findMenu*/
SELECT bm.*,mu.user_name FROM base_menu bm
LEFT JOIN user_menu um ON bm.menu_code = um.menu_code
LEFT JOIN man_users mu ON mu.user_id = um.user_id
WHERE mu.user_id=@userId