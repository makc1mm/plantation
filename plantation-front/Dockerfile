FROM node:slim as build
WORKDIR /home
COPY package*.json .
RUN npm install
COPY . .
RUN npm run build

FROM nginx:stable-alpine
#ADD ./nginx.conf /etc/nginx/nginx.conf
COPY --from=build /home/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
