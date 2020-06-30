# couchbase-multi-bucket-spring-boot


Notes
-------

```


Search without any index creation
-------------------------------------
SELECT META(`bucketName`).id AS _ID, *  from `bucketName` 
use keys['id']



#CREATE PRIMARY INDEX ON `customer-bkt` USING GSI;
#CREATE PRIMARY INDEX ON `user-bkt` USING GSI;
#CREATE PRIMARY INDEX ON `session-bkt` USING GSI;
#Create a custom user inside security tab and use that credentials inside application.yml
```

