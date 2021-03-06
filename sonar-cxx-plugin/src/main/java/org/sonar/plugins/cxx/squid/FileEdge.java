/*
 * Sonar C++ Plugin (Community)
 * Copyright (C) 2010 Neticoa SAS France
 * sonarqube@googlegroups.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.cxx.squid;

import org.sonar.api.resources.File;
import org.sonar.graph.Edge;

class FileEdge implements Edge<File> {

  private final File from;
  private final File to;
  private final int line;

  public FileEdge(File from, File to, int line) {
    this.from = from;
    this.to = to;
    this.line = line;
  }

  @Override
  public int getWeight() {
    return 1;
  }

  @Override
  public File getFrom() {
    return from;
  }

  @Override
  public File getTo() {
    return to;
  }

  public int getLine() {
    return line;
  }
}
