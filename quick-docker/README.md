> 使用Docker部署服务

将src文件和pom放在任意文件夹下，执行命令
```bash
mvn package docker:build
```

启动服务
`docker run -d -p 8080:8080 vector4wang/quick-docker` 

> DockerHub

```bash
[root@iZ2zejaebtdc3kosrltpqaZ code]# docker login
```
接下来就是推送的了，执行命令` docker push vector4wang/quick-docker:latest`

```bash
docker pull vector4wang/quick-docker
```
就能快速部署并启动一个应用，网络快的话，能达到秒级别的



mvn clean package docker:build


### Prometheus+Grafana
reference: https://www.cnblogs.com/niechen/p/10150004.html
#### precompare
pom, application.properties, *Application.java(集成grafana), docker-compose.yml+prom.yml(regist).
At last, run app and validate url "http://localhost:8080/actuator/prometheus"

#### prometheus
docker-compose up -d 
http://192.168.122.1:9090/targets

#### grafana
add datasource
import jvm-micrometer

https://grafana.com/dashboards/4701
(https://grafana.com/grafana/dashboards)



#### 报警信息配置
界面设置消息，或者
开启smtp许可, 在docker启动容器时设置环境变量来配置邮件服务的信息：
```bash
docker run
    -p 3000:3000
    --env GF_SMTP_ENABLED=true
    --env GF_SMTP_HOST=smtp.qq.com:465
    --env GF_SMTP_USER=xxxx
    --env GF_SMTP_PASSWORD=xxxxx
    --env GF_SMTP_SKIP_VERIFY=true
    --env GF_SMTP_FROM_ADDRESS=xxxxx@qq.com
    --name grafana
grafana/grafana:latest 
```



prom.yml
```bash
#Global configurations
global:
  scrape_interval:     15s # Set the scrape interval to every 5 seconds.
  evaluation_interval: 15s # Evaluate rules every 5 seconds.
scrape_configs:
  - job_name: 'prometheus'
    static_configs:
      - targets: ['127.0.0.1:9090']
  - job_name: 'quick-docker_prometheus'
    scrape_interval: 10s
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['192.168.122.1:8080']

```

