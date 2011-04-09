update DictItem set itemType='Charge' where itemId like 'Charge%' ;
update DictItem set itemType='Currency' where itemId like 'Currency%' ;
update DictItem set itemType='BookLevel' where itemId like 'BookLevel%' ;
update DictItem set itemType='BookState' where itemId like 'BookState%' ;
update DictItem set itemType='BookSource' where itemId like 'BookSource%' ;
update DictItem set itemType='Certificate' where itemId like 'Certificate%' ;
update DictItem set itemType='BookSecurity' where itemId like 'BookSecurity%' ;
update DictItem set leaf=1 where 
itemId like 'Charge_%' or 
itemId like 'Currency_%' or 
itemId like 'BookLevel_%' or 
itemId like 'BookState_%' or 
itemId like 'Certificate_%' or 
itemId like 'BookSecurity_%';

insert Role(roleId, roleName, roleDesc, createDate, roleActive)
values(1, '��������Ա', 'ӵ��ϵͳ����Ȩ��', '2011-04-09', 1);