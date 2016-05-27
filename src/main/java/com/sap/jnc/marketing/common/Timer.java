package com.sap.jnc.marketing.common;

/**
 * Simple timer to measure the elapsed time between {@link #start()} and {@link #end()}.
 *
 * @author Peter Nagy
 */
public class Timer {
	/**
	 * Self-explanatory.
	 */
	private static final int SECONDS_IN_AN_HOUR = 3600;
	/**
	 * Self-explanatory.
	 */
	private static final int SECONDS_IN_A_MINUTE = 60;
	/**
	 * Self-explanatory.
	 */
	private static final int MILLISECONDS_IN_A_SECOND = 1000;
	/**
	 * The unix timestamp of the start.
	 */
	private long startTime = 0;
	/**
	 * The unix timestamp of the end.
	 */
	private long endTime = 0;
	/**
	 * Optional subject for a formatted total time output, see {@link #getFormattedTotalTime()}.
	 */
	private String subject = null;

	/**
	 * Starts the timer.
	 *
	 * @return this instance
	 */
	public Timer start() {
		this.startTime = System.currentTimeMillis();
		return this;
	}

	/**
	 * Starts the timer with a subject, see {@link #getFormattedTotalTime()}.
	 *
	 * @param subject
	 *            the subject.
	 * @return this instance
	 */
	public Timer start(final String subject) {
		this.subject = subject;
		return this.start();
	}

	/**
	 * Stops the timer. It also sets the member {@link #endTime}.
	 */
	public void end() {
		this.endTime = System.currentTimeMillis();
	}

	/**
	 * Returns the value of field <code>{@link #startTime}</code>.
	 *
	 * @return the startTime
	 */
	public long getStartTime() {
		return this.startTime;
	}

	/**
	 * Returns the value of field <code>{@link #endTime}</code>.
	 *
	 * @return the endTime
	 */
	public long getEndTime() {
		return this.endTime;
	}

	/**
	 * Calculates and returns the total elapsed time, in ms
	 *
	 * @return the total elapsed time or the current time, if the timer hasn't been started by calling {@link #start()}.
	 */
	public long getTotalTime() {
		return (this.endTime == 0 ? System.currentTimeMillis() : this.endTime) - this.startTime;
	}

	/**
	 * Returns a formatted total time.
	 *
	 * @return the formatted total time, hh:mm:ss.
	 */
	public String getFormattedTotalTime() {
		long totaltime = this.getTotalTime() / MILLISECONDS_IN_A_SECOND;
		final long hour = (totaltime - (totaltime % SECONDS_IN_AN_HOUR)) / SECONDS_IN_AN_HOUR;
		totaltime -= hour * SECONDS_IN_AN_HOUR;
		final long min = (totaltime - (totaltime % SECONDS_IN_A_MINUTE)) / SECONDS_IN_A_MINUTE;
		totaltime -= min * SECONDS_IN_A_MINUTE;
		final long sec = totaltime;

		final String subject = (this.subject != null) ? this.subject + " finished in " : "";
		return subject + String.format("%02d:%02d:%02d", hour, min, sec);
	}
}
