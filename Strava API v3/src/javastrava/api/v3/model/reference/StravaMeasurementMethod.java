package javastrava.api.v3.model.reference;

import javastrava.config.Messages;
import javastrava.config.StravaConfig;
import javastrava.json.impl.gson.serializer.MeasurementMethodSerializer;

/**
 * <p>
 * Preferred measurement system for an athlete. Those of you living in the 19th century will prefer {@link #IMPERIAL}
 * </p>
 * 
 * @author Dan Shannon
 *
 */
public enum StravaMeasurementMethod {
	/**
	 * Imperial units
	 */
	IMPERIAL(StravaConfig.string("StravaMeasurementMethod.imperial"), Messages.string("StravaMeasurementMethod.imperial.description")),  //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * Metric
	 */
	METRIC(StravaConfig.string("StravaMeasurementMethod.metric"), Messages.string("StravaMeasurementMethod.metric.description")),  //$NON-NLS-1$ //$NON-NLS-2$
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
	 * Private constructor used by declarations
	 * @param id Identifier - also used when serialising/deserialising to JSON
	 * @param description Description
	 */
	private StravaMeasurementMethod(final String id, final String description) {
		this.id = id;
		this.description = description;
	}

	/**
	 * Used by JSON serialisation
	 * @return The string representation of the {@link StravaMeasurementMethod} to be used with the Strava API
	 * @see MeasurementMethodSerializer#serialize(StravaMeasurementMethod, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	public String getValue() {
		return this.id;
	}

	/**
	 * Used by JSON deserialisation
	 * @param id The string representation of the {@link StravaMeasurementMethod} returned by the Strava API
	 * @return The matching {@link StravaMeasurementMethod}, or {@link StravaMeasurementMethod#UNKNOWN} if there is no match
	 */
	public static StravaMeasurementMethod create(final String id) {
		StravaMeasurementMethod[] methods = StravaMeasurementMethod.values();
		for (StravaMeasurementMethod method : methods) {
			if (method.getId().equals(id)) {
				return method;
			}
		}
		return StravaMeasurementMethod.UNKNOWN;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

}
