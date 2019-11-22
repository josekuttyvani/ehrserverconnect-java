# ehrserverconnect
Java client for EHRServer

Update pom.xml

```
<dependency>
     <groupId>com.synnefx.ehrserver</groupId>
     <artifactId>ehrconnect</artifactId>
     <version>1.0-SNAPSHOT</version>
</dependency>
```

Create an instance of the client `EhrServerConnect ehrServerConnect = new EhrServerConnect();`

To enable debug mode use the constructor `new EhrServerConnect(true)`.

You can also set proxy using the constructor `EhrServerConnect(Proxy userProxy, boolean enableDebugLog)`

To create new EHR:

```
        EhrHealthRecord healthRecord = new EhrHealthRecord();
        String mrdNumber = UUID.randomUUID().toString();
        healthRecord.setSubjectUid(mrdNumber);
        healthRecord = ehrServerConnect.createHealthRecord(healthRecord, $api_token_for_the_organization$);
```

In order to list first 10 EHR:
```
        EhrPageRequest pageRequest = new EhrPageRequest();
        pageRequest.setMaxRecords(10);
        List<EhrHealthRecord> healthRecords = ehrServerConnect.listHealthRecords($api_token_for_the_organization$, pageRequest);
```

##### Commit Compostion
```
      String response = ehrServerConnect.createComposition("xml to be committed", "Name of the comitter", $ehrId$, $api_token_for_the_organization$);
 ```
  Response will be returned as string.
  
Executing query is made possible

```
    EhrQueryParameter parameter = new EhrQueryParameter(); //Will set default criteria for EHR Query execution
    parameter.setComposerUid($composer_uid$);
    String result = ehrServerConnect.runQuery("e2bf308a-9106-4e76-9784-feb349dfec34", parameter, apiToken);
     
```


