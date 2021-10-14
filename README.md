[![Quality Gate Status](http://128.199.209.141:9000/api/project_badges/measure?project=dogoo_be&metric=alert_status)](http://128.199.209.141:9000/dashboard?id=dogoo_be)

Fix permission

https://stackoverflow.com/questions/17668265/gradlew-permission-denied

`chmod +x gradlew`

```
git update-index --chmod=+x gradlew
git add .
git commit -m "Changing permission of gradlew"
git push
```



# Liferay CE

Version: `7.4GA2`


# Database

PostgreSQL `11.12`

# ELK

Elastic version `7.3.0`

####Configure
LR -> Control Panel -> System Settings -> find 'elastic'

Install some plugins

* `elasticsearch-plugin.bat install analysis-icu`
* `elasticsearch-plugin.bat install analysis-smartcn`
* `elasticsearch-plugin.bat install analysis-kuromoji`
* `elasticsearch-plugin.bat install analysis-stempel`

TODO:
* secure for Elastic
* cluster

Kibana version `7.3.0`

### Blade CLI

`blade init -v 7.3 [WORKSPACE_NAME]`

`blade create [OPTIONS] <NAME>`

example create an MVC Portlet

`blade create -t mvc-portlet -p com.liferay.docs.guestbook -c GuestbookPortlet my-guestbook-project`

`blade create -t service-builder -p com.dogoo.authz authz`

`blade create -t rest-builder -p com.dogoo.authz.rest authz-rest`