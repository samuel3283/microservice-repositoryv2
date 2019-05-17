Failed to obtain JDBC Connection; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: 
Access denied for user 'admin'@'%' to database 'repositorio

docker search mysql
docker pull centos/mysql-56-centos7
--CREA CONTENEDOR containerMysql con cuenta admin/admin con el puerto 3306
docker run -d --name container-mysql -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin -e MYSQL_DATABASE=repositorio -p 3306:3306 centos/mysql-56-centos7


docker exec -it container-mysql /bin/bash

docker ps
Acceso mysql
admin/admin

mysql -uroot
GRANT ALL ON *.* to admin@'%' IDENTIFIED BY 'admin';
GRANT ALL ON *.* to root@'%' IDENTIFIED BY 'root';
