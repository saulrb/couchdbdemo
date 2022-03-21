package org.studying.couchdb.couchdbdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = "org.studying.couchdb.couchdbdemo.repositories")
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    public static final String SERVICE_URL = "couchbase://127.0.0.1";
    public static final String USER_NAME = "Administrator";
    public static final String USER_PASSWORD = "Srb9196Sftk";
    public static final String BUCKET_NAME = "dev-bucket";
    public static final String SCOPE_NAME = "dev-test-scope";

    @Override
    protected String getScopeName() {
        return SCOPE_NAME;
    }

    @Override
    public String getConnectionString() {
        return SERVICE_URL;
    }

    @Override
    public String getUserName() {
        return USER_NAME;
    }

    @Override
    public String getPassword() {
        return USER_PASSWORD;
    }

    @Override
    public String getBucketName() {
        return BUCKET_NAME;
    }

}
