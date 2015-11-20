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
pio build
```

First install predictionIO python SDK:

```
pip install predictionio
```


Import train data:

```
python data/import_eventserver.py --access_key ObMGjcvvBt6Skn1lBgvvDXpR7DUbO02tN9IjyPya0R3s6sgBmqG2ZQ5gjIBbUNST
```



