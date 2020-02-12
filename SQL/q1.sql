SELECT name FROM member WHERE member.id IN(
	SELECT checkout_item.member_id FROM checkout_item, book
	 WHERE book.title = 'The Hobbit' AND book.id = checkout_item.book_id);