FROM node:20.14.0-alpine as builder

RUN npm i -g @ionic/cli
RUN npm i -g @angular/cli

WORKDIR /usr/app

COPY ./ /usr/app

RUN npm install

RUN ionic build 

FROM nginx:1.25

COPY --from=builder /usr/app/www /usr/share/nginx/html
