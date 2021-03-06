package javastrava.api.v3.service;

import java.util.concurrent.CompletableFuture;

import javastrava.api.v3.model.StravaActivity;
import javastrava.api.v3.model.StravaAthlete;
import javastrava.api.v3.model.StravaGear;
import javastrava.api.v3.model.reference.StravaResourceState;
import javastrava.api.v3.service.exception.UnauthorizedException;

/**
 * <p>
 * {@link StravaGear} related services.
 * </p>
 *
 * <p>
 * StravaGear represents equipment used during an {@link StravaActivity}.
 * </p>
 *
 * <p>
 * The object is returned in summary or detailed {@link StravaResourceState representations}.
 * </p>
 *
 * @author Dan Shannon
 *
 */
public interface GearService extends StravaService {
	/**
	 * <p>
	 * Retrieve details about a specific item of {@link StravaGear}. The requesting {@link StravaAthlete} must own the {@link StravaGear}. At this time it is
	 * not possible to view just anyone's gear type and usage.
	 * </p>
	 *
	 * <p>
	 * Returns <code>null</code> if club with the given id does not exist
	 * </p>
	 *
	 * <p>
	 * URL GET https://www.strava.com/api/v3/gear/:id
	 * </p>
	 *
	 * @see <a href="http://strava.github.io/api/v3/gear/#show">http://strava.github.io/api/v3/gear/#show</a>
	 *
	 * @param gearId
	 *            The id of the {@link StravaGear} to be retrieved.
	 * @return Returns a detailed {@link StravaGear} representation.
	 * @throws UnauthorizedException
	 *             If service token is invalid
	 */
	public StravaGear getGear(final String gearId);

	/**
	 * <p>
	 * Retrieve details about a specific item of {@link StravaGear}. The requesting {@link StravaAthlete} must own the {@link StravaGear}. At this time it is
	 * not possible to view just anyone's gear type and usage.
	 * </p>
	 *
	 * <p>
	 * Returns <code>null</code> if club with the given id does not exist
	 * </p>
	 *
	 * <p>
	 * URL GET https://www.strava.com/api/v3/gear/:id
	 * </p>
	 *
	 * @see <a href="http://strava.github.io/api/v3/gear/#show">http://strava.github.io/api/v3/gear/#show</a>
	 *
	 * @param gearId
	 *            The id of the {@link StravaGear} to be retrieved.
	 * @return Returns a detailed {@link StravaGear} representation.
	 * @throws UnauthorizedException
	 *             If service token is invalid
	 */
	public CompletableFuture<StravaGear> getGearAsync(final String gearId);
}
