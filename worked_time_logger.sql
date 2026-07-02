-- Database must have the name "worked_time_logger";
--- Create a type TASK_STATUS 
DO $$
BEGIN
	IF NOT EXISTS (
		SELECT 1 FROM pg_type typ 
		INNER JOIN pg_namespace nsp ON nsp.oid = typ.typnamespace 
      	WHERE nsp.nspname = current_schema() AND typ.typname = 'task_status'
	) THEN
		CREATE TYPE task_status AS ENUM('TO_DO', 'IN_PROGRESS', 'CANCELED', 'DONE');
 	END IF;
END $$;
CREATE TABLE IF NOT EXISTS tb_user_details(
	user_details_id SERIAL PRIMARY KEY,
	name varchar(255) NOT NULL,
	email varchar (100) NOT NULL
);
CREATE TABLE IF NOT EXISTS tb_user(
	user_id SERIAL PRIMARY KEY,
	user_details_id INT NOT NULL REFERENCES tb_user_details(user_details_id),
	username VARCHAR(100) NOT NULL,
	password VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS tb_task(
	task_id SERIAL PRIMARY KEY,
	created_by INT NOT NULL REFERENCES tb_user(user_id),
	name VARCHAR(255) NOT NULL,
	status TASK_STATUS NOT NULL
);
CREATE TABLE IF NOT EXISTS tb_worked_time(
	worked_time_id SERIAL PRIMARY KEY,
	user_id INT NOT NULL,
	task_id INT NOT NULL,
	start_time TIMESTAMP NOT NULL,
	end_time TIMESTAMP NOT NULL
);

