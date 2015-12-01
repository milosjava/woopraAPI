# Woopra Recommender



## Woopra Developers API


Woopra Developers API docs are organized in several sections:



* [API Introduction](https://www.woopra.com/docs/developer/api-introduction/)

* [Analytics/Reports API](https://www.woopra.com/docs/developer/analytics-api/)

* [Funnels API](https://www.woopra.com/docs/developer/funnels-api/)

* [Profiles/Search API](https://www.woopra.com/docs/developer/search-api/)

* [Import/Export API](https://www.woopra.com/docs/developer/import-export-api/)

* [Retention API](https://www.woopra.com/docs/developer/retention-api/)

* [Labels API](https://www.woopra.com/docs/developer/labels-api/)

* [Schema API](https://www.woopra.com/docs/developer/schema-api/)

* [Built In Fields](https://www.woopra.com/docs/developer/built-in-fields/)

* [Segmentation Filters](https://www.woopra.com/docs/developer/segmentation-filters/)

* [HTTP Tracking API](https://www.woopra.com/docs/developer/http-tracking-api/)


### Woopra API keys

Keys can be generated on this [page](https://www.woopra.com/members/settings/access-keys).


## Remote ec2

I am using nex command for accessing remote server:

```
ssh -i ~/.ssh/prediction_eren ubuntu@ec2-52-64-15-25.ap-southeast-2.compute.amazonaws.com
```

## PredictionIO

### Installation

Detailed installation guide is given [here](https://docs.prediction.io/install/).  

I suggest the automatic installation which can be started by typing:

```
bash -c "$(curl -s https://install.prediction.io/install.sh)"
```

Follow the installation guide.  After installation is completed make sure to start the service:

```
pio-start-all
```

Check status  by typing:

```
pio status --verbose
```

### Templates

Templates gallery is located [here](https://templates.prediction.io/).


Downloading templates to some folder e.g. *recommenderWoopra* can be achieved with next command:

```
pio template get PredictionIO/template-scala-parallel-recommendation recommenderWoopra
```

Edit file **engine.json** and set up the value for appName field.

Initialize and get the key for the app:

```
pio app new woopraRecommender
```


Go  into recommenderWoopra folder  and run

```
pio build --verbose
```

First install predictionIO python SDK. Be careful to include **sudo** cause missing it will pop some strange error 
messages.

```
sudo easy_install predictionio
```


Import train data:

```
python data/import_eventserver.py --access_key ObMGjcvvBt6Skn1lBgvvDXpR7DUbO02tN9IjyPya0R3s6sgBmqG2ZQ5gjIBbUNST
```


# Debug Template

Follow https://docs.prediction.io/resources/intellij/ with two notes:

1. For **pio train** run configuration , for environment use those from PredcitionIO/conf/pio-env.sh
2. For module pio-runtime-jars remove scala from dependencies

# Delete all application data on event server

```
pio app data-delete woopraRecommender
```

## Dump event table sample

```
/home/sensei/PredictionIO/vendors/hbase-1.0.0/bin/hbase org.apache.hadoop.hbase.mapreduce.Export "pio_event:events_1" data_dump
```

## Restore event table sample

```
/opt/PredictionIO/vendors/hbase-1.0.0/bin/hbase org.apache.hadoop.hbase.mapreduce.Import  "pio_event:events_1" data_dump
```

## Check event server is populated

```
curl -i -X GET "http://localhost:7070/events.json?accessKey=1lKeD1zfnKJ2sbkSvG4RgWiFkzEmTuYpoh7hXyDIkGrOOOaLHPfwLiTX8tIvoGcS"
```

## Troubleshooting

* Check who is occupying port 8000

```
fuser 8000/tcp
```


## Operations with PredictionIO server



* Deploy

```
pio deploy
```

* Undeploy

```
curl <host>:<port>/stop   (e.g.  curl localhost:8000/stop)
```

* Reload

```
curl <host>:<port>/stop   (e.g.  curl localhost:8000/reload)
```

* Get recommendations

Here's example

```
curl -H "Content-Type: application/json" -d '{ "user": "eren testing", "num": 4 }' localhost:8000/queries.json
```