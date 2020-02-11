/**
 * This file is part of the PlotView distribution (https://github.com/mad-lab-fau/PlotView).
 * Copyright (c) 2015-2020 Machine Learning and Data Analytics Lab, Friedrich-Alexander-Universität Erlangen-Nürnberg (FAU).
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 * <p>
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package de.fau.mad.plotview;

import android.graphics.Paint;
import android.util.Log;

/**
 * SamplingPlot for displaying (real time) sampling data. IMPORTANT: the Android
 * (software) drawing operations require about 10-50 ms, depending on the number
 * of samples displayed in the viewport. So remember to change the maxRedrawRate
 * in the PlotView accordingly to avoid lags!
 *
 * @author Stefan Gradl
 */
public class SamplingPlot extends Plot1D {
    /**
     * @param plotTitle
     * @param paint
     * @param style
     * @param maxCache
     */
    public SamplingPlot(String plotTitle, Paint paint, PlotStyle style, int maxCache) {
        super(plotTitle, paint, style, maxCache);
        // TODO Auto-generated constructor stub
    }

    public SamplingPlot(String plotTitle, Paint paint, PlotStyle style, int maxCache, boolean maintainMinMax) {
        super(plotTitle, paint, style, maxCache, maintainMinMax);
        // TODO Auto-generated constructor stub
    }

    /**
     * Adds a single sample to this plot. The current system time is used as
     * timestamp. You should only use this method if you don't have a
     * millisecond timestamp at hand.
     *
     * @param value sample-value
     */
    public void addValue(long value) {
        // TODO: implement the add directly
        addValue(value, System.currentTimeMillis());
    }

    /**
     * Specify a time window of how many samples should be drawn in the view. If
     * the number of seconds is larger than the maximal number of seconds
     * specified on construction, that value is used.
     *
     * @param timeInSeconds The number of seconds of the time window to display.
     */
    public void setViewport(int samplingRateInHz, int timeInSeconds) {
        m_desiredViewportIdxNum = timeInSeconds * samplingRateInHz;
    }

    @Override
    protected String formatAxisText(PlotAxis axis, int pt) {
        if (axis == xAxis) {
            if (m_idxStart + m_numIdxPerPixel * pt >= x.num)
                return "n/a";

            long timeInMillis = x.get((int) (m_idxStart + m_numIdxPerPixel * pt));
            return String.format("%.2f", (double) timeInMillis / 1000d);
        } else if (axis == valueAxis && m_yPxScale != 0) {
            if (m_yPxScale > 10)
                return String.format("%.2f", ((-m_yPxTrans + pt / m_yPxScale) * axis.multiplier));
            else
                return String.format("%.0f", ((-m_yPxTrans + pt / m_yPxScale) * axis.multiplier));
        }

        return "n/a";
    }
}
