FROM mysql:8.0.18
ENV MYSQL_DATABASE news
ENV MYSQL_ROOT_PASSWORD password

# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup
COPY create-table.sql /docker-entrypoint-initdb.d/
COPY inserts.sql /docker-entrypoint-initdb.d/