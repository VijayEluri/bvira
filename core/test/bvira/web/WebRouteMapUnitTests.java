package bvira.web;

import bvira.framework.Presenter;
import bvira.framework.RequestContext;
import bvira.framework.RequestUri;
import bvira.framework.ResponseContext;
import org.junit.Assert;
import org.junit.Test;

public class WebRouteMapUnitTests {

    @Test
    public void testCanCreateRouteMap() {
        new WebRouteMap();
    }

    @Test
    public void testCanRegisterRoute() {
        WebRouteMap map = new WebRouteMap();

        map.registerPresenter(new WebRoute("/"), null);
    }

    @Test
    public void testRouteMapMatchesSuppliedRoute() {
        WebRouteMap map = new WebRouteMap();

        class APresenter implements Presenter {

            public void present(RequestContext requestContext, ResponseContext responseContext) {
            }
        }

        map.registerPresenter(new WebRoute("/"), APresenter.class);

        RequestUri requestUri = new RequestUri("/", "");
        Assert.assertSame(APresenter.class, map.findPresenter(requestUri));
    }

}