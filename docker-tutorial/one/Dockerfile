FROM ubuntu:20.04

RUN apt-get update -y && \
    apt-get install nginx -y && \
    echo "\ndaemon off;" >> /etc/nginx/nginx.conf && \
    echo "<h1>Hello Soma</h1>" > /var/www/html/index.html

ENTRYPOINT ["nginx"]

EXPOSE 80

