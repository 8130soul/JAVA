---
####事务操作
1. 编程式事务管理
    1. 开启事务管理
    1. 进行事务操作
    1. 没有异常，提交事务操作
    1. 发生异常，回滚事务操作
2. 声明式（使用）事务管理
    2. 基于xml
        2. 配置事务管理器
        2. 配置通知
        2. 配置切入点和切面
    2. 注解方式（使用）
        2. 在spring配置文件中配置事务管理器 org.springframework.jdbc.datasource.DataSourceTransactionManager
        2. 开启事务注解
            2. 引入名称空间 tx
        2. 在业务逻辑层（service层）类或方法上添加事务注解
            2. @Transactional
    2. 声明式事务管理参数配置
        2. propagation:事务传播行为（七种 重点介绍前三个）
        当一个事务方法被另一个事务方法调用，这个事务方法如何进行
            2. 传播行为:REQUIRED 如果有事务在运行，当前方法在这              个事务内进行，否则启动一个新事务，并在自己的事务内进行
            2. 传播行为:REQUIRED_NEW 当前方法必须启动新事物，               并在自己的事务内运行，如果有事务在运行，应该讲它挂起
            2.传播行为:SUPPORTS:如果有事务在运行，当前方法就在              这个事务中运行，否则它可以不运行在事务中
        2. isolation:事务隔离级别  解决脏读 不可重复读 幻读问题
            2.所要解决的问题
                2. 脏读:指某一个事务读取到了其他事务未提交的数据，如果此数据回滚，将导致读取到的数据是错误的数据。
                2. 不可重复读 指某个事务在开启后，读取某个范围或者某条数据时，在此事务未结束的时间里内，其他事务对表内的数据进行了添加，或者更改了某一条或者多条数据后进行了提交，此时本事务读取到的数据条数与之前某时间段读取到的条数不相同，或者在读取一条数据时，两个时间段内读取到的数据值不相同。
                2. 幻读:在一个事务开启后，其他事务对表中的一行或者多行进行了更改操作后进行了提交，本事务读取到的一行或多行的值仍和数量然是相同的，此时并不能读到其他事务在本事务查询时，提交的更改内容，即：其他事务对此表的更改本事务不能读到，这达成了可重复读的目的，但是读取到的数据是虚幻的。如果其他事物在此之间真实的更改了数据，则在本事务提交之前的读操作，读取到的都是未被更改前的数据，造成了读取的数据是虚幻的。
            2. Read uncommitted(读未提交):如果一个事务已经开始写数据，则另外一个事务不允许同时进行写操作，但允许其他事务读此行数据，该隔离级别可以通过“排他写锁”，但是不排斥读线程实现。`解决了更新丢失，但还是可能会出现脏读.`
            2. Read committed(读提交):如果是一个读事务(线程)，则允许其他事务读写，如果是写事务将会禁止其他事务访问该行数据，`该隔离级别避免了脏读，但是可能出现不可重复读。`
            2. Repeatable read(可重复读取):可重复读取是指在一个事务内，多次读同一个数据，在这个事务还没结束时，其他事务不能访问该数据(包括了读写)，这样就可以在同一个事务内两次读到的数据是一样的，因此称为是可重复读隔离级别，读取数据的事务将会禁止写事务(但允许读事务)，写事务则禁止任何其他事务(包括了读写)，这样`避免了不可重复读和脏读，但是有时可能会出现幻读`。(读取数据的事务)可以通过“共享读镜”和“排他写锁”实现。
            2. Serializable(可序化):供严格的事务隔离，它要求事务序列化执行，事务只能一个接着一个地执行，但不能并发执行，如果仅仅通过“行级锁”是无法实现序列化的，必须通过其他机制保证新插入的数据不会被执行查询操作的事务访问到。序列化是最高的事务隔离级别，同时代价也是最高的，性能很低，一般很少使用，在该级别下，事务顺序执行，不仅可以避免脏读、不可重复读，还避免了幻读.
        2. timeout:超时时间
        2. readOnly:是否只读
        2. rollbackFor:回滚
        2. noRollbackFor:不回滚