UPDATE bank_account SET amount_number=CASE
 WHEN amount_number IS NULL OR amount_number='' THEN '300'
ELSE amount_number+'300' END WHERE ac_num=2

 update bank_account
  set amount_number=amount_number-500
  where amount_number=2000;



   update bank_account set amount_number=amount_number+500 where amount_number=2500;