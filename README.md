# ehrserverconnect
Java client for EHRServer

Update pom.xml

```
<dependency>
     <groupId>com.synnefx.ehrserver</groupId>
     <artifactId>ehrconnect</artifactId>
     <version>1.1-SNAPSHOT</version>
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

You can use API Key generated for a given organization or can use Username+Password+organizationId combo to generate a token for EhrServer API authentication. For the later 
```
String authenticationToken - ehrServerConnect.generateAccessToken("username", "password", "organizationId");
```

In order to list first 10 EHR:
```
        EhrPageRequest pageRequest = new EhrPageRequest();
        pageRequest.setMaxRecords(10);
        List<EhrHealthRecord> healthRecords = ehrServerConnect.listHealthRecords($api_token_for_the_organization$, pageRequest);
```

##### Commit Compostion
```
     String response = ehrServerConnect.createComposition("xml to be committed", "Name of the comitter", $ehrId$,       $api_token_for_the_organization$);
 ```
  Response will be returned as string.
  
  You can also user org.apache.xmlbeans.XmlObject instances to create a composition instance and commit to EHRServer.
```       
        //Utils.initComposition(Constants.COMPOSITION_FILE_NAME) for test purpose only
        VersionDocument versionDocument = Utils.initComposition(Constants.COMPOSITION_FILE_NAME);
        updateData(versionDocument);
        String response = ehrServerConnect.createComposition(versionDocument, "Josekutty T", ehrId, apiToken);
        assertNotNull("Commit response can't be null", response);
```
  
#### Asynchronous Commit
```
 VersionDocument version = Utils.initComposition(Constants.COMPOSITION_FILE_NAME);
        updateData(version);
        ehrServerConnect.sendComposition(version, "Name of the committer", ehrId, apiToken, new AsyncResponseHandler() {
            @Override
            public void onError(String code, String message) {
               //Do something to handle Commit error. Trigger an event may be?
                assertNotNull("Error message can't be null", message);
            }

            @Override
            public void onSuccess() {
                //Any follow up action on successful commit. 
            }
        });
 ```
  
##### Executing query is made possible

```
    EhrQueryParameter parameter = new EhrQueryParameter(); //Will set default criteria for EHR Query execution
    parameter.setComposerUid($composer_uid$);
    String result = ehrServerConnect.runQuery("e2bf308a-9106-4e76-9784-feb349dfec34", parameter, apiToken);     
```


