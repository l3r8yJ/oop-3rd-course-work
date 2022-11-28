/*
 * The MIT License (MIT)
 * Copyright (c) 2022 Ivan Ivanchuk
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.ivanchuk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class App {

  private final int port;

  App(final int prt) {
    this.port = prt;
  }

  public void start() throws IOException {
    final ServerSocket server = new ServerSocket(this.port);
    final Socket socket = server.accept();
    final InputStream input = socket.getInputStream();
    final OutputStream output = socket.getOutputStream();
    output.write("HTTP/1.1 200 OK\r\n\r\nHello, friend!".getBytes());
    final byte[] buffer = new byte[10000];
    input.read(buffer);
    input.close();
    output.close();
    server.close();
  }
}
