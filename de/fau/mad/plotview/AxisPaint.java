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

/**
 * @author Stefan Gradl
 */
public class AxisPaint {
    public Paint defaultPaint;
    public Paint background;
    public Paint majorLine;
    public Paint ticks;
    public Paint title;
    public Paint text;

    public AxisPaint(Paint paint, Paint text) {
        defaultPaint = paint;
        background = paint;
        majorLine = paint;
        ticks = paint;
        title = text;
        this.text = text;

        background = Plot.generatePlotPaint(1f, 255, 192, 192, 192);
        background.setStyle(Paint.Style.FILL_AND_STROKE);
    }
}
