# Tinder For Broccoli Main App
----
This is the main application for Tinder For Broccoli

__Usage__

`docker-compose up` to build image and start container. Building the image automatically runs tests.

`GET localhost:8080/multiply?start={startNumber}` to multiply startNumber by 10

`docker-compose down -v --rmi 'all'` will close the container and delete the old image
