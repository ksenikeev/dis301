# Concurrent API

`java.util.concurrent`

## Интерфейс Callable

`java.util.concurrent.Callable`

```java
public interface Callable<V> {
    V call() throws Exception;
}
```

## Интерфейс Future

`java.util.concurrent.Future`

```java
public interface Future<V> {
    boolean cancel(boolean mayInterruptIfRunning);
    boolean isCancelled();
    boolean isDone();
    // синхронный вызов
    V get() throws InterruptedException, ExecutionException;
    V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
    // если знаем, что задача завершена - получаем результат
    default V resultNow() { /*...*/ }
    default State state() { /*...*/ } // (RUNNING, SUCCESS, FAILED, CANCELLED)
    //...
}
```

Имеется реализация `java.util.concurrent.FutureTask`

Это реализация двух интерфейсов: `Runnable`, `Future`

## CompletableFuture

`CompletableFuture` реализует интерфейсы `CompletionStage`, `Future`

Даёт управление результатами выполнения асинхронных операций.

- Композиция - из нескольких объектов `CompletableFuture` создается новый
- Получение уведомления о завершении операции
- Ожидание окончания завершения операции

Композиция: 
- cf.thenCombine(cf, (a,b) -> f(a,b)
```java
.thenCombine


```