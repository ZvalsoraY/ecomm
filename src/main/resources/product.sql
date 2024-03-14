SELECT prd.id prod_id,
		prd.user_id produser_id,
        USERS.id user_id,
        USERS.name user_name,
        USERS.patronymic user_patronymic,
        USERS.surname user_surname,
        prd.title prod_title,
        prd.description prod_description,
        prd.dateplaced prod_dateplaced,
        prd.price prod_price,
        prd.currency prod_currency
        FROM PRODUCTS prd
        JOIN USERS ON prd.user_id = USERS.id

