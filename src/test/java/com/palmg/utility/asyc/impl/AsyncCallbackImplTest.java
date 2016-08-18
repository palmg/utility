package com.palmg.utility.asyc.impl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.junit.Test;

import com.palmg.utility.async.CallbackResult;

/**
 * 测试CallbakcResult功能
 * @author chkui
 */
public class AsyncCallbackImplTest {
	@Test
	public void Success() {
		CompletableFuture<String> future1 = new CompletableFuture<String>();
		CompletableFuture<String> future2 = new CompletableFuture<String>();

		new Thread(() -> {
			CallBackSuccess(ret -> {
				if (ret.isSuccess()) {
					future1.complete(ret.getResult());
				} else {
					future1.completeExceptionally(ret.getCause());
				}
			});
			CallBackSuccessStr(ret -> {
				if (ret.isSuccess()) {
					future2.complete(ret.getResult());
				} else {
					future2.completeExceptionally(ret.getCause());
				}
			});
		}).start();
		
		CompletableFuture<Void> end = new CompletableFuture<Void>();
		CompletableFuture.allOf(future1, future2).whenComplete((results, ex) -> {
			if (ex == null) {
				Assert.assertEquals(future1.getNow("Error"), "SUC");
				Assert.assertEquals(future2.getNow("Error"), "SUCCESS");
				end.complete(null);
			} else {
				end.completeExceptionally(ex);
			}
		});
		try {
			end.get(3, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	private void CallBackSuccess(CallbackResult<String> callback) {
		callback.success("SUC");
	}

	private void CallBackSuccessStr(CallbackResult<String> callback) {
		callback.success("SUCCESS");
	}
}