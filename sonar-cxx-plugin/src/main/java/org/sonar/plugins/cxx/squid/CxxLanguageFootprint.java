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

import java.util.HashSet;
import java.util.Set;

import org.sonar.squid.recognizer.ContainsDetector;
import org.sonar.squid.recognizer.Detector;
import org.sonar.squid.recognizer.EndWithDetector;
import org.sonar.squid.recognizer.KeywordsDetector;
import org.sonar.squid.recognizer.LanguageFootprint;

/**
 * {@inheritDoc}
 */
public final class CxxLanguageFootprint implements LanguageFootprint {

  /**
   * {@inheritDoc}
   */
  @Override
  public Set<Detector> getDetectors() {
    final Set<Detector> detectors = new HashSet<>();

    detectors.add(new EndWithDetector(0.95, '}', ';', '{'));
    detectors.add(new KeywordsDetector(0.7, "||", "&&"));
    detectors.add(new KeywordsDetector(0.95, "#define", "#endif", "#ifdef", "#ifndef", "#include"));
    detectors.add(new KeywordsDetector(0.3, "auto", "class", "do", "double", "float", "for", "int", "long", "mutable", "namespace",
      "operator", "private", "protected", "public", "return", "sizeof", "short", "static", "struct", "template", "throw", "typedef",
      "typename", "union", "void", "while"));
    detectors.add(new ContainsDetector(0.95, "++", "--"));
    return detectors;
  }

}
