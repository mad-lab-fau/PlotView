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
 * Three-dimensional (space) plot
 *
 * @author Stefan Gradl
 */
public class Plot3D extends Plot2D {
    protected LongValueList z;

    /**
     * @param plotTitle
     * @param xUnitName
     * @param yUnitName
     * @param m_paint
     * @param style
     * @param maxCache
     */
    public Plot3D(String plotTitle, Paint paint, PlotStyle style, int maxCache) {
        super(plotTitle, paint, style, maxCache);
        // TODO Auto-generated constructor stub
    }

}
