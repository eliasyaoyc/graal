/*
 * Copyright (c) 2018, 2018, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.svm.core.posix;

import java.io.IOException;

import org.graalvm.nativeimage.Platforms;
import org.graalvm.nativeimage.impl.DeprecatedPlatform;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import com.oracle.svm.core.jdk.JDK11OrLater;
import com.oracle.svm.core.posix.headers.Unistd;

@Platforms({DeprecatedPlatform.LINUX_SUBSTITUTION.class, DeprecatedPlatform.DARWIN_SUBSTITUTION.class})
@TargetClass(className = "java.io.FileCleanable", onlyWith = JDK11OrLater.class)
final class Target_java_io_FileCleanable {

    /* { Do not re-format commented out C code. @formatter:off */
    @Substitute //
    @SuppressWarnings({"unused"})
    // Translated from open-jdk11/src/java.base/unix/native/libjava/FileDescriptor_md.c
    // 84  JNIEXPORT void JNICALL
    // 85  Java_java_io_FileCleanable_cleanupClose0(JNIEnv *env, jclass fdClass, jint fd, jlong unused) {
    private static /* native */ void cleanupClose0(int fd, long handle) throws IOException {
        // 86      if (fd != -1) {
        if (fd != -1) {
            // 87          if (close(fd) == -1) {
            if (Unistd.close(fd) == -1) {
                // 88              JNU_ThrowIOExceptionWithLastError(env, "close failed");
                throw PosixUtils.newIOExceptionWithLastError("close failed");
            }
        }
    }
    /* } Do not re-format commented out C code. @formatter:on */
}
