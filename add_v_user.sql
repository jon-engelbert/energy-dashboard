CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `energy`.`v_user_role` AS select `u`.`User_Name` AS `user_name`,`u`.`User_Password` AS `user_password`,`g`.`group_name` AS `group_name` from (`energy`.`users` `u` join `energy`.`groups` `g` on((`u`.`isAdmin` = `g`.`group_id`))); 

INSERT INTO `v_user_role` (`user_name`, `user_password`, `group_name`) VALUES('thien', '098F6BCD4621D373CADE4E832627B4F6', 'USER'), ('jon', '098F6BCD4621D373CADE4E832627B4F6', 'USER'),('xander', 'FB469D7EF430B0BAF0CAB6C436E70375', 'NEW');
