package stravajava.api.v3.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import stravajava.api.v3.model.reference.StravaActivityType;
import stravajava.api.v3.model.reference.StravaResourceState;
import stravajava.api.v3.model.reference.StravaWorkoutType;
import stravajava.api.v3.service.ActivityServices;
import stravajava.api.v3.service.StreamServices;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * A run, ride, or other activity
 * </p>
 * 
 * @author Dan Shannon
 *
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class StravaActivity {
	/**
	 * Strava's unique identifier for the activity
	 */
	private Integer id;
	/**
	 * State of the resource (summary, detailed, etc.)
	 */
	private StravaResourceState resourceState;
	/**
	 * The identifier given to the activity by the application that uploaded it
	 */
	private String externalId;
	/**
	 * The athlete performing the activity
	 */
	private StravaAthlete athlete;
	/**
	 * Name of the activity. Defaults to boring things, but athletes with
	 * imagination will come up with witty and interesting names on a regular
	 * basis!
	 */
	private String name;
	/**
	 * Detailed description of the activity
	 */
	private String description;
	/**
	 * Distance travelled in metres. If you want it in funny old imperial,
	 * that's up to you to convert it
	 */
	private Float distance;
	/**
	 * Total moving time in seconds.
	 */
	private Integer movingTime;
	/**
	 * Total time including stopped time, in seconds
	 */
	private Integer elapsedTime;
	/**
	 * Total elevation gain in metres
	 */
	private Float totalElevationGain;
	/**
	 * Type of activity
	 */
	private StravaActivityType type;
	/**
	 * Date and time the activity was started
	 */
	private Date startDate;
	/**
	 * Date and time the activity was started, in local time zone
	 */
	private Date startDateLocal;
	/**
	 * Time zone
	 */
	private String timeZone;
	/**
	 * Start location
	 */
	private StravaMapPoint startLatLng;
	/**
	 * End location
	 */
	private StravaMapPoint endLatLng;
	/**
	 * City the activity started in
	 */
	private String locationCity;
	/**
	 * State or county or canton or whatever other thing that the activity
	 * started in
	 */
	private String locationState;
	/**
	 * Country that the activity started in
	 */
	private String locationCountry;
	/**
	 * <p>
	 * Total number of achievements for this activity (returned by Strava, not
	 * recalculated by javastrava)
	 * </p>
	 */
	private Integer achievementCount;
	/**
	 * <p>
	 * Total number of athletes who have left kudos on this activity (returned
	 * by Strava, not recalculated by javastrava)
	 * </p>
	 * 
	 * <p>
	 * To get the actual list of athletes who have left kudos, see
	 * {@link ActivityServices#listActivityKudoers(Integer, stravajava.util.Paging)}
	 * </p>
	 */
	private Integer kudosCount;
	/**
	 * <p>
	 * Total number of comments left on this activity (returned by Strava, not
	 * recalculated by javastrava)
	 * </p>
	 * 
	 * <p>
	 * To get the actual list of comments, see
	 * {@link ActivityServices#listActivityComments(Integer, Boolean, stravajava.util.Paging)}
	 * </p>
	 */
	private Integer commentCount;
	/**
	 * <p>
	 * If Strava thinks this was a group activity, this is the number of
	 * athletes taking part
	 * </p>
	 * 
	 * <p>
	 * To get the list of activities by all the other people who also took part,
	 * see
	 * {@link ActivityServices#listRelatedActivities(Integer, stravajava.util.Paging)}
	 * </p>
	 */
	private Integer athleteCount;
	/**
	 * <p>
	 * Total number of photos attached to this activity by the athlete
	 * </p>
	 * 
	 * <p>
	 * To get the actual photo details, see
	 * {@link ActivityServices#listActivityPhotos(Integer)}
	 * </p>
	 */
	private Integer photoCount;
	/**
	 * <p>
	 * Weird map representation returned with the activity, basically contains
	 * polylines for use on Google maps
	 * </p>
	 * 
	 * <p>
	 * If you want the actual set of GPS coordinates of the activity, then you
	 * need to use
	 * {@link StreamServices#getActivityStreams(Integer, stravajava.api.v3.model.reference.StravaStreamResolutionType, stravajava.api.v3.model.reference.StravaStreamSeriesDownsamplingType, stravajava.api.v3.model.reference.StravaStreamType...)}
	 * </p>
	 */
	private StravaMap map;
	/**
	 * Is set to <code>true</code> if Strava believes the ride was done on an
	 * indoor trainer
	 */
	private Boolean trainer;
	/**
	 * Is set to <code>true</code> if the activity was flagged as a commute</p>
	 */
	private Boolean commute;
	/**
	 * Is set to <code>true</code> if the activity was manually entered into
	 * Strava, rather than being uploaded as a file from some GPS device, or
	 * your phone</p>
	 */
	private Boolean manual;
	/**
	 * Is set to <code>true</code> if the activity has been flagged as private
	 * by the athlete
	 */
	@SerializedName("private")
	private Boolean privateActivity;
	/**
	 * Is set to <code>true</code> if the activity has been flagged as
	 * suspicious by another user on Strava, usually because it has crazy speeds
	 * because it was done in a car, not on a bike
	 */
	private Boolean flagged;
	/**
	 * For runs only, 0 -> ‘default’, 1 -> ‘race’, 2 -> ‘long run’, 3 ->
	 * ‘intervals’
	 */
	private StravaWorkoutType workoutType;
	/**
	 * Unique identifier of the {@link StravaGear} used on this activity
	 */
	private String gearId;
	/**
	 * Summary representation of the gear used for the activity
	 */
	private StravaGear gear;
	/**
	 * Average speed (in metres per second) of the activity (as calculated by
	 * Strava; is not recalculated or checked by javastrava)
	 */
	private Float averageSpeed;
	/**
	 * Maximum speed (in metres per second) achieved during the activity (quite
	 * often as a result of GPS inaccuracies). Calculated by Strava and not
	 * recalculated or checked by javastrava.
	 */
	private Float maxSpeed;
	/**
	 * Average RPM if cadence data was provided with the uploaded activity
	 */
	private Float averageCadence;
	/**
	 * Average temperature (in degrees Celsius) if temperature data was provided
	 * with the uploaded activity
	 */
	private Float averageTemp;
	/**
	 * Average power (in watts) for rides only. Strava calculates an estimate
	 * for this if power meter data is not provided with the upload.
	 */
	private Float averageWatts;
	/**
	 * Weighted average power (in watts) for rides with power meter data only.
	 */
	private Float weightedAverageWatts;
	/**
	 * Total energy expended by the rider in kilojoules
	 */
	private Float kilojoules;
	/**
	 * Is set to <code>true</code> if power meter data was provided with the
	 * upload
	 */
	private Boolean deviceWatts;
	/**
	 * Average heart rate (in beats per minute) if heart rate data was provided
	 * with the upload
	 */
	private Float averageHeartrate;
	/**
	 * Maximum heart rate (in beats per minute) if heart rate data was provided
	 * with the upload
	 */
	private Integer maxHeartrate;
	/**
	 * Kilocalories expended (calculated by Strava)
	 */
	private Float calories;
	/**
	 * Only present if activity is owned by authenticated athlete, returns 0 if
	 * not truncated by privacy zones
	 */
	private Integer truncated;
	/**
	 * Is set to <code>true</code> if the currently authenticated athlete has
	 * kudoed this activity
	 */
	private Boolean hasKudoed;
	/**
	 * Segment efforts associated with the activity
	 */
	private List<StravaSegmentEffort> segmentEfforts;
	/**
	 * Runs only - list of metric splits
	 */
	private List<StravaSplit> splitsMetric;
	/**
	 * Runs only - list of imperial splits ("standard" hahahaha you Americans
	 * are so funny)
	 */
	private List<StravaSplit> splitsStandard;
	/**
	 * Runs only - list of best efforts
	 */
	private List<StravaBestRunningEffort> bestEfforts;
}
