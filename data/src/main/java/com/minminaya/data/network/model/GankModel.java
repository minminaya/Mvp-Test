package com.minminaya.data.network.model;

import java.util.List;

/**
 * Created by Niwa on 2017/5/21.
 */

public class GankModel {
    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }


}
