#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class KrotAnswer, KrotPlayer, KrotRes<__covariant T>, KrotChallenge, KrotResError, KrotKotlinNothing, KrotKotlinx_serialization_coreSerializersModule, KrotKotlinx_serialization_coreSerialKind, KrotKotlinThrowable, KrotKotlinArray<T>, KrotKotlinException, KrotKotlinRuntimeException, KrotKotlinIllegalStateException;

@protocol KrotKotlinx_serialization_coreEncoder, KrotKotlinx_serialization_coreSerialDescriptor, KrotKotlinx_serialization_coreSerializationStrategy, KrotKotlinx_serialization_coreDecoder, KrotKotlinx_serialization_coreDeserializationStrategy, KrotKotlinx_serialization_coreKSerializer, KrotClientListener, KrotKotlinx_serialization_coreCompositeEncoder, KrotKotlinAnnotation, KrotKotlinx_serialization_coreCompositeDecoder, KrotKotlinx_serialization_coreSerializersModuleCollector, KrotKotlinKClass, KrotKotlinIterator, KrotKotlinKDeclarationContainer, KrotKotlinKAnnotatedElement, KrotKotlinKClassifier;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

__attribute__((swift_name("KotlinBase")))
@interface KrotBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end;

@interface KrotBase (KrotBaseCopying) <NSCopying>
@end;

__attribute__((swift_name("KotlinMutableSet")))
@interface KrotMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((swift_name("KotlinMutableDictionary")))
@interface KrotMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorKrotKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((swift_name("KotlinNumber")))
@interface KrotNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end;

__attribute__((swift_name("KotlinByte")))
@interface KrotByte : KrotNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((swift_name("KotlinUByte")))
@interface KrotUByte : KrotNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((swift_name("KotlinShort")))
@interface KrotShort : KrotNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((swift_name("KotlinUShort")))
@interface KrotUShort : KrotNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((swift_name("KotlinInt")))
@interface KrotInt : KrotNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((swift_name("KotlinUInt")))
@interface KrotUInt : KrotNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((swift_name("KotlinLong")))
@interface KrotLong : KrotNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((swift_name("KotlinULong")))
@interface KrotULong : KrotNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((swift_name("KotlinFloat")))
@interface KrotFloat : KrotNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((swift_name("KotlinDouble")))
@interface KrotDouble : KrotNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((swift_name("KotlinBoolean")))
@interface KrotBoolean : KrotNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializationStrategy")))
@protocol KrotKotlinx_serialization_coreSerializationStrategy
@required
- (void)serializeEncoder:(id<KrotKotlinx_serialization_coreEncoder>)encoder value:(id _Nullable)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<KrotKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreDeserializationStrategy")))
@protocol KrotKotlinx_serialization_coreDeserializationStrategy
@required
- (id _Nullable)deserializeDecoder:(id<KrotKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
@property (readonly) id<KrotKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreKSerializer")))
@protocol KrotKotlinx_serialization_coreKSerializer <KrotKotlinx_serialization_coreSerializationStrategy, KrotKotlinx_serialization_coreDeserializationStrategy>
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AnswerSerializer")))
@interface KrotAnswerSerializer : KrotBase <KrotKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)answerSerializer __attribute__((swift_name("init()")));
- (KrotAnswer *)deserializeDecoder:(id<KrotKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<KrotKotlinx_serialization_coreEncoder>)encoder value:(KrotAnswer *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<KrotKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Client")))
@interface KrotClient : KrotBase
- (instancetype)initWithRoot:(NSString *)root tellTime:(KrotLong *(^)(void))tellTime __attribute__((swift_name("init(root:tellTime:)"))) __attribute__((objc_designated_initializer));
- (BOOL)addListenerListener:(id<KrotClientListener>)listener __attribute__((swift_name("addListener(listener:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)askServerStatusWithCompletionHandler:(void (^)(NSString * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("askServerStatus(completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)enterGamePlayer:(KrotPlayer *)player completionHandler:(void (^)(KrotRes<NSString *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("enterGame(player:completionHandler:)")));
- (void)handlePushData:(NSDictionary<NSString *, id> *)data __attribute__((swift_name("handlePush(data:)")));
- (BOOL)removeListenerListener:(id<KrotClientListener>)listener __attribute__((swift_name("removeListener(listener:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)submitAnswerAnswer:(NSString *)answer completionHandler:(void (^)(KrotRes<NSString *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("submitAnswer(answer:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Client.Companion")))
@interface KrotClientCompanion : KrotBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (readonly) NSString *TAG __attribute__((swift_name("TAG")));
@end;

__attribute__((swift_name("ClientListener")))
@protocol KrotClientListener
@required
- (void)onAnyEventEvent:(NSString *)event data:(NSDictionary<NSString *, id> * _Nullable)data __attribute__((swift_name("onAnyEvent(event:data:)")));
- (void)onChallengeQuestion:(NSString *)question __attribute__((swift_name("onChallenge(question:)")));
- (void)onErrorMessage:(NSString *)message __attribute__((swift_name("onError(message:)")));
- (void)onGameEndedMessage:(NSString *)message __attribute__((swift_name("onGameEnded(message:)")));
- (void)onGameStartedMessage:(NSString *)message __attribute__((swift_name("onGameStarted(message:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PlayerSerializer")))
@interface KrotPlayerSerializer : KrotBase <KrotKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)playerSerializer __attribute__((swift_name("init()")));
- (KrotPlayer *)deserializeDecoder:(id<KrotKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<KrotKotlinx_serialization_coreEncoder>)encoder value:(KrotPlayer *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<KrotKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Answer")))
@interface KrotAnswer : KrotBase
- (instancetype)initWithGameId:(NSString *)gameId playerId:(NSString *)playerId challengeId:(NSString *)challengeId answer:(NSString *)answer tookTime:(int32_t)tookTime __attribute__((swift_name("init(gameId:playerId:challengeId:answer:tookTime:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (int32_t)component5 __attribute__((swift_name("component5()")));
- (KrotAnswer *)doCopyGameId:(NSString *)gameId playerId:(NSString *)playerId challengeId:(NSString *)challengeId answer:(NSString *)answer tookTime:(int32_t)tookTime __attribute__((swift_name("doCopy(gameId:playerId:challengeId:answer:tookTime:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *answer __attribute__((swift_name("answer")));
@property (readonly) NSString *challengeId __attribute__((swift_name("challengeId")));
@property (readonly) NSString *gameId __attribute__((swift_name("gameId")));
@property (readonly) NSString *playerId __attribute__((swift_name("playerId")));
@property (readonly) int32_t tookTime __attribute__((swift_name("tookTime")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Answer.Companion")))
@interface KrotAnswerCompanion : KrotBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (KrotAnswer *)leavePlayerId:(NSString *)playerId __attribute__((swift_name("leave(playerId:)")));
- (KrotAnswer *)noAnswerPlayerId:(NSString *)playerId __attribute__((swift_name("noAnswer(playerId:)")));
- (KrotAnswer *)timeoutPlayerId:(NSString *)playerId __attribute__((swift_name("timeout(playerId:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Challenge")))
@interface KrotChallenge : KrotBase
- (instancetype)initWithId:(NSString *)id gameId:(NSString *)gameId question:(NSString *)question correctAnswer:(NSString *)correctAnswer __attribute__((swift_name("init(id:gameId:question:correctAnswer:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (KrotChallenge *)doCopyId:(NSString *)id gameId:(NSString *)gameId question:(NSString *)question correctAnswer:(NSString *)correctAnswer __attribute__((swift_name("doCopy(id:gameId:question:correctAnswer:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *correctAnswer __attribute__((swift_name("correctAnswer")));
@property (readonly) NSString *gameId __attribute__((swift_name("gameId")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) NSString *question __attribute__((swift_name("question")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Keys")))
@interface KrotKeys : KrotBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)keys __attribute__((swift_name("init()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Player")))
@interface KrotPlayer : KrotBase
- (instancetype)initWithId:(NSString *)id nickName:(NSString *)nickName fcmToken:(NSString *)fcmToken lat:(float)lat long:(float)long_ radius:(float)radius __attribute__((swift_name("init(id:nickName:fcmToken:lat:long:radius:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (float)component4 __attribute__((swift_name("component4()")));
- (float)component5 __attribute__((swift_name("component5()")));
- (float)component6 __attribute__((swift_name("component6()")));
- (KrotPlayer *)doCopyId:(NSString *)id nickName:(NSString *)nickName fcmToken:(NSString *)fcmToken lat:(float)lat long:(float)long_ radius:(float)radius __attribute__((swift_name("doCopy(id:nickName:fcmToken:lat:long:radius:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *fcmToken __attribute__((swift_name("fcmToken")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) float lat __attribute__((swift_name("lat")));
@property (readonly, getter=long) float long_ __attribute__((swift_name("long_")));
@property (readonly) NSString *nickName __attribute__((swift_name("nickName")));
@property (readonly) float radius __attribute__((swift_name("radius")));
@end;

__attribute__((swift_name("Res")))
@interface KrotRes<__covariant T> : KrotBase
- (T _Nullable)dealWithErrorOnError:(void (^)(KrotResError *))onError __attribute__((swift_name("dealWithError(onError:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ResError")))
@interface KrotResError : KrotRes<KrotKotlinNothing *>
- (instancetype)initWithMessage:(NSString *)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *message __attribute__((swift_name("message")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ResSuccess")))
@interface KrotResSuccess<T> : KrotRes<T>
- (instancetype)initWithData:(T _Nullable)data __attribute__((swift_name("init(data:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) T _Nullable data __attribute__((swift_name("data")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Settings")))
@interface KrotSettings : KrotBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)settings __attribute__((swift_name("init()")));
@property (readonly) int64_t ANSWER_TIMEOUT __attribute__((swift_name("ANSWER_TIMEOUT")));
@property (readonly) NSString *CHALLENGES_FILE_COLUMNS __attribute__((swift_name("CHALLENGES_FILE_COLUMNS")));
@property (readonly) NSString *CHALLENGES_FILE_ID_GOOGLE_DOC __attribute__((swift_name("CHALLENGES_FILE_ID_GOOGLE_DOC")));
@property (readonly) NSString *CREDENTIALS_FILE_NAME __attribute__((swift_name("CREDENTIALS_FILE_NAME")));
@property (readonly) NSString *DATABASE_URL __attribute__((swift_name("DATABASE_URL")));
@property (readonly) int32_t DRAWS_TO_FINISH __attribute__((swift_name("DRAWS_TO_FINISH")));
@property (readonly) int32_t WINS_TO_FINISH __attribute__((swift_name("WINS_TO_FINISH")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreEncoder")))
@protocol KrotKotlinx_serialization_coreEncoder
@required
- (id<KrotKotlinx_serialization_coreCompositeEncoder>)beginCollectionDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor collectionSize:(int32_t)collectionSize __attribute__((swift_name("beginCollection(descriptor:collectionSize:)")));
- (id<KrotKotlinx_serialization_coreCompositeEncoder>)beginStructureDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)enumDescriptor index:(int32_t)index __attribute__((swift_name("encodeEnum(enumDescriptor:index:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));
- (void)encodeNull __attribute__((swift_name("encodeNull()")));
- (void)encodeNullableSerializableValueSerializer:(id<KrotKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));
- (void)encodeSerializableValueSerializer:(id<KrotKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
@property (readonly) KrotKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerialDescriptor")))
@protocol KrotKotlinx_serialization_coreSerialDescriptor
@required
- (NSArray<id<KrotKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));
- (id<KrotKotlinx_serialization_coreSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));
@property (readonly) NSArray<id<KrotKotlinAnnotation>> *annotations __attribute__((swift_name("annotations")));
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));
@property (readonly) BOOL isNullable __attribute__((swift_name("isNullable")));
@property (readonly) KrotKotlinx_serialization_coreSerialKind *kind __attribute__((swift_name("kind")));
@property (readonly) NSString *serialName __attribute__((swift_name("serialName")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreDecoder")))
@protocol KrotKotlinx_serialization_coreDecoder
@required
- (id<KrotKotlinx_serialization_coreCompositeDecoder>)beginStructureDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)enumDescriptor __attribute__((swift_name("decodeEnum(enumDescriptor:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));
- (KrotKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<KrotKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));
- (id _Nullable)decodeSerializableValueDeserializer:(id<KrotKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
@property (readonly) KrotKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((swift_name("KotlinThrowable")))
@interface KrotKotlinThrowable : KrotBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(KrotKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KrotKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (KrotKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) KrotKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
@end;

__attribute__((swift_name("KotlinException")))
@interface KrotKotlinException : KrotKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KrotKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(KrotKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinRuntimeException")))
@interface KrotKotlinRuntimeException : KrotKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KrotKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(KrotKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinIllegalStateException")))
@interface KrotKotlinIllegalStateException : KrotKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KrotKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(KrotKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinCancellationException")))
@interface KrotKotlinCancellationException : KrotKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KrotKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(KrotKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface KrotKotlinNothing : KrotBase
@end;

__attribute__((swift_name("Kotlinx_serialization_coreCompositeEncoder")))
@protocol KrotKotlinx_serialization_coreCompositeEncoder
@required
- (void)encodeBooleanElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(descriptor:index:value:)")));
- (void)encodeByteElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(descriptor:index:value:)")));
- (void)encodeCharElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(descriptor:index:value:)")));
- (void)encodeDoubleElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(descriptor:index:value:)")));
- (void)encodeFloatElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(descriptor:index:value:)")));
- (void)encodeIntElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(descriptor:index:value:)")));
- (void)encodeLongElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(descriptor:index:value:)")));
- (void)encodeNullableSerializableElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<KrotKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeSerializableElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<KrotKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeShortElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(descriptor:index:value:)")));
- (void)encodeStringElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(descriptor:index:value:)")));
- (void)endStructureDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
- (BOOL)shouldEncodeElementDefaultDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(descriptor:index:)")));
@property (readonly) KrotKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModule")))
@interface KrotKotlinx_serialization_coreSerializersModule : KrotBase
- (void)dumpToCollector:(id<KrotKotlinx_serialization_coreSerializersModuleCollector>)collector __attribute__((swift_name("dumpTo(collector:)")));
- (id<KrotKotlinx_serialization_coreKSerializer> _Nullable)getContextualKclass:(id<KrotKotlinKClass>)kclass __attribute__((swift_name("getContextual(kclass:)")));
- (id<KrotKotlinx_serialization_coreSerializationStrategy> _Nullable)getPolymorphicBaseClass:(id<KrotKotlinKClass>)baseClass value:(id)value __attribute__((swift_name("getPolymorphic(baseClass:value:)")));
- (id<KrotKotlinx_serialization_coreDeserializationStrategy> _Nullable)getPolymorphicBaseClass:(id<KrotKotlinKClass>)baseClass serializedClassName:(NSString * _Nullable)serializedClassName __attribute__((swift_name("getPolymorphic(baseClass:serializedClassName:)")));
@end;

__attribute__((swift_name("KotlinAnnotation")))
@protocol KrotKotlinAnnotation
@required
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerialKind")))
@interface KrotKotlinx_serialization_coreSerialKind : KrotBase
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreCompositeDecoder")))
@protocol KrotKotlinx_serialization_coreCompositeDecoder
@required
- (BOOL)decodeBooleanElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(descriptor:index:)")));
- (int8_t)decodeByteElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeByteElement(descriptor:index:)")));
- (unichar)decodeCharElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeCharElement(descriptor:index:)")));
- (int32_t)decodeCollectionSizeDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeCollectionSize(descriptor:)")));
- (double)decodeDoubleElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(descriptor:index:)")));
- (int32_t)decodeElementIndexDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeElementIndex(descriptor:)")));
- (float)decodeFloatElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeFloatElement(descriptor:index:)")));
- (int32_t)decodeIntElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeIntElement(descriptor:index:)")));
- (int64_t)decodeLongElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeLongElement(descriptor:index:)")));
- (id _Nullable)decodeNullableSerializableElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<KrotKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeNullableSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (BOOL)decodeSequentially __attribute__((swift_name("decodeSequentially()")));
- (id _Nullable)decodeSerializableElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<KrotKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (int16_t)decodeShortElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeShortElement(descriptor:index:)")));
- (NSString *)decodeStringElementDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeStringElement(descriptor:index:)")));
- (void)endStructureDescriptor:(id<KrotKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
@property (readonly) KrotKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface KrotKotlinArray<T> : KrotBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(KrotInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<KrotKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModuleCollector")))
@protocol KrotKotlinx_serialization_coreSerializersModuleCollector
@required
- (void)contextualKClass:(id<KrotKotlinKClass>)kClass serializer:(id<KrotKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("contextual(kClass:serializer:)")));
- (void)polymorphicBaseClass:(id<KrotKotlinKClass>)baseClass actualClass:(id<KrotKotlinKClass>)actualClass actualSerializer:(id<KrotKotlinx_serialization_coreKSerializer>)actualSerializer __attribute__((swift_name("polymorphic(baseClass:actualClass:actualSerializer:)")));
- (void)polymorphicDefaultBaseClass:(id<KrotKotlinKClass>)baseClass defaultSerializerProvider:(id<KrotKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultSerializerProvider __attribute__((swift_name("polymorphicDefault(baseClass:defaultSerializerProvider:)")));
@end;

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol KrotKotlinKDeclarationContainer
@required
@end;

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol KrotKotlinKAnnotatedElement
@required
@end;

__attribute__((swift_name("KotlinKClassifier")))
@protocol KrotKotlinKClassifier
@required
@end;

__attribute__((swift_name("KotlinKClass")))
@protocol KrotKotlinKClass <KrotKotlinKDeclarationContainer, KrotKotlinKAnnotatedElement, KrotKotlinKClassifier>
@required
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName __attribute__((swift_name("qualifiedName")));
@property (readonly) NSString * _Nullable simpleName __attribute__((swift_name("simpleName")));
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol KrotKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
