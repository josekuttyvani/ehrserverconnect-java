package com.synnefx.ehrserver;

import com.synnefx.ehrserver.exception.EhrServerException;
import com.synnefx.ehrserver.models.EhrPageRequest;
import com.synnefx.ehrserver.models.query.EhrQuery;
import com.synnefx.ehrserver.models.query.EhrQueryParameter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Josekutty
 * 22-11-2019
 */
public class EhrQueryTest {

    private String apiToken = Constants.API_TOKEN;

    private String ehrId = Constants.EHR_ID;

    private EhrServerConnect ehrServerConnect;

    private EhrPageRequest pageRequest;

    private String getToken() throws EhrServerException, IOException {
        return ehrServerConnect.generateAccessToken("admin", "admin", "123456");
    }

    @Before
    public void setUp() {
        ehrServerConnect = new EhrServerConnect(apiToken, true);
        pageRequest = new EhrPageRequest();
    }

    @Test
    public void testListQuery() throws IOException, EhrServerException {
        List<EhrQuery> queries = ehrServerConnect.listQueries(apiToken, pageRequest);
        assertNotNull("Queries can not be empty", queries);
        assertNotEquals("Queries can not be empty", 0, queries.size());
    }

    @Test
    public void testGetQuery() throws IOException, EhrServerException {
        EhrQuery ehrQuery = ehrServerConnect.getQuery("e2bf308a-9106-4e76-9784-feb349dfec34", apiToken);
        assertNotNull("Query can not be null", ehrQuery);
        assertEquals("Wrong query fetched", ehrQuery.getUid(), "e2bf308a-9106-4e76-9784-feb349dfec34");
    }

    @Test
    public void testExecuteSavedQuery() throws IOException, EhrServerException {
        EhrQueryParameter parameter = new EhrQueryParameter();
        String result = ehrServerConnect.runQuery("e2bf308a-9106-4e76-9784-feb349dfec34", parameter, apiToken);
        assertNotNull("Query can not be null", result);
        //assertEquals("Wrong query fetched", ehrQuery.getUid(), "e2bf308a-9106-4e76-9784-feb349dfec34");
    }
}
