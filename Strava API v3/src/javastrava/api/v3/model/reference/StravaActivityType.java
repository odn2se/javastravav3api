package javastrava.api.v3.model.reference;

import javastrava.config.Messages;
import javastrava.config.StravaConfig;
import javastrava.json.impl.gson.serializer.ActivityTypeSerializer;

/**
 * <p>
 * Possible values: ride, run, swim, workout, hike, walk, nordicski, alpineski, backcountryski, iceskate, inlineskate, kitesurf,
 * rollerski, windsurf, workout, snowboard, snowshoe
 * </p>
 * 
 * <p>
 * Type detected from file upload overrides, uses athlete's default type if not specified
 * </p>
 * 
 * @author Dan Shannon
 *
 */
public enum StravaActivityType {
	/**
	 * Bike ride
	 */
	RIDE(StravaConfig.string("StravaActivityType.ride"), Messages.string("StravaActivityType.ride.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Run
	 */
	RUN(StravaConfig.string("StravaActivityType.run"), Messages.string("StravaActivityType.run.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Swim
	 */
	SWIM(StravaConfig.string("StravaActivityType.swim"), Messages.string("StravaActivityType.swim.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Workout
	 */
	WORKOUT(StravaConfig.string("StravaActivityType.workout"), Messages.string("StravaActivityType.workout.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Hike
	 */
	HIKE(StravaConfig.string("StravaActivityType.hike"), Messages.string("StravaActivityType.hike.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Walk
	 */
	WALK(StravaConfig.string("StravaActivityType.walk"), Messages.string("StravaActivityType.walk.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Nordic skiing (telemark)
	 */
	NORDIC_SKI(StravaConfig.string("StravaActivityType.nordicski"), Messages.string("StravaActivityType.nordicski.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Alpine skiing
	 */
	ALPINE_SKI(StravaConfig.string("StravaActivityType.alpineski"), Messages.string("StravaActivityType.alpineski.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Back-country skiing (off piste)
	 */
	BACKCOUNTRY_SKI(StravaConfig.string("StravaActivityType.backcountryski"), Messages.string("StravaActivityType.backcountryski.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Ice skating
	 */
	ICE_SKATE(StravaConfig.string("StravaActivityType.iceskate"), Messages.string("StravaActivityType.iceskate.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Inline skating (rollerblading)
	 */
	INLINE_SKATE(StravaConfig.string("StravaActivityType.inlineskate"), Messages.string("StravaActivityType.inlineskate.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Kite surfing
	 */
	KITESURF(StravaConfig.string("StravaActivityType.kitesurf"), Messages.string("StravaActivityType.kitesurf.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Rollerskiing
	 */
	ROLLERSKI(StravaConfig.string("StravaActivityType.rollerski"), Messages.string("StravaActivityType.rollerski.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Windsurfing
	 */
	WINDSURF(StravaConfig.string("StravaActivityType.windsurf"), Messages.string("StravaActivityType.windsurf.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Snowboarding
	 */
	SNOWBOARD(StravaConfig.string("StravaActivityType.snowboard"), Messages.string("StravaActivityType.snowboard.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Snowshoeing
	 */
	SNOWSHOE(StravaConfig.string("StravaActivityType.snowshoe"), Messages.string("StravaActivityType.snowshoe.description")), //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * <p>
	 * Should never occur but may if Strava API behaviour has changed
	 * </p>
	 */
	UNKNOWN(StravaConfig.string("Common.unknown"), Messages.string("Common.unknown.description")); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Identifier
	 */
	private String	id;
	/**
	 * Description
	 */
	private String	description;

	/**
	 * Private constructor used by declarations above
	 * @param id Identifier (used in JSON)
	 * @param description Description
	 */
	private StravaActivityType(final String id, final String description) {
		this.id = id;
		this.description = description;
	}

	/**
	 * @return The id
	 */
	public String getValue() {
		return this.id;
	}

	/**
	 * @param id The string representation of the activity type as returned by the Strava API
	 * @return The {@link StravaActivityType} with the matching id, or {@link StravaActivityType#UNKNOWN} if there is no match
	 * @see ActivityTypeSerializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	public static StravaActivityType create(final String id) {
		for (StravaActivityType type : StravaActivityType.values()) {
			if (type.getId().equalsIgnoreCase(id)) {
				return type;
			}
		}
		return UNKNOWN;
	}

	/**
	 * @return the id
	 * @see ActivityTypeSerializer#serialize(StravaActivityType, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.id;
	}

}
