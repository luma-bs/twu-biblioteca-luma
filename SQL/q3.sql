SELECT book.title 
FROM book 
WHERE book.id NOT IN(
	SELECT checkout_item.book_id 
	FROM checkout_item
	WHERE checkout_item.book_id NOT NULL)
	UNION 
	SELECT movie.title 
	FROM movie 
	WHERE movie.id NOT IN (
SELECT checkout_item.movie_id
FROM checkout_item
WHERE checkout_item.movie_id
);