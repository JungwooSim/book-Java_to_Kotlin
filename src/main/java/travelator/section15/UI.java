package travelator.section15;

import java.time.Duration;
import java.util.List;

public class UI {

    public void render(Iterable<Journey> route) {
        for (var journey : route) {
            render(journey);
        }
    }

    public void renderWithHeader(List<Journey> route) {
        renderHeader(
                RouteKt.getDepartsFrom(route), // <1>
                RouteKt.getArrivesAt(route),
                RouteKt.getDuration(route)
        );
        for (int i = 0; i < RouteKt.size(route); i++) {
            var journey = RouteKt.get(route, i);
            render(journey);
        }
    }

    private void render(Journey journey) {
    }

    private void renderHeader(
            Location departsFrom,
            Location arrivesAt,
            Duration duration) {
    }
}
