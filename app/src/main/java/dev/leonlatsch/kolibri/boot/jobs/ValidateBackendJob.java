package dev.leonlatsch.kolibri.boot.jobs;

import android.content.Context;
import android.content.SharedPreferences;

import dev.leonlatsch.kolibri.boot.jobs.base.Job;
import dev.leonlatsch.kolibri.boot.jobs.base.JobResult;
import dev.leonlatsch.kolibri.settings.Config;

import static dev.leonlatsch.kolibri.settings.Config.KEY_BACKEND_BROKER_HOST;
import static dev.leonlatsch.kolibri.settings.Config.KEY_BACKEND_BROKER_PORT;
import static dev.leonlatsch.kolibri.settings.Config.KEY_BACKEND_HTTP_BASEURL;

/**
 * Sync job to validate the backend config
 *
 * @author Leon Latsch
 * @since 1.0.0
 */
public class ValidateBackendJob extends Job {

    private SharedPreferences preferences;

    public ValidateBackendJob(Context context) {
        super(context);
        preferences = Config.getSharedPreferences(context);
    }

    @Override
    public JobResult<Void> execute() {
        String baseUrl = preferences.getString(KEY_BACKEND_HTTP_BASEURL, null);
        String brokerHost = preferences.getString(KEY_BACKEND_BROKER_HOST, null);
        int brokerPort = preferences.getInt(KEY_BACKEND_BROKER_PORT, 0);

        if (baseUrl == null || brokerHost == null || brokerPort == 0) {
            return new JobResult<>(false, null);
        } else {
            return new JobResult<>(true, null);
        }
    }
}
