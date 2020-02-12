SELECT COUNT (DISTINCT member.id) 
FROM member
WHERE member.id NOT IN (
	SELECT checkout_item.member_id
	FROM checkout_item);